/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebas.controller;

import com.sebas.view.ClienteView;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import javax.swing.SwingUtilities;

/**
 *
 * @author sebath
 */
public class ClienteController {
    
    // declaramos las variables principales
    private ClienteView view;
    private Socket s;
    private BufferedReader dataIn;
    private PrintWriter dataOut;
    private int numberCount = 0;
    private String address = "127.0.0.1";
    private int port = 6000; 

    // creamos el constructor de la clase ClienteController
    public ClienteController(ClienteView view) {
        this.view = view;
        this.view.addSendButtonListener(this::handleSendButton);
        this.view.setSendButtonEnabled(false); // deshabilitamos el boton al inicio
    }

    // creamos el metodo start que inicie la conexion
    public void start() {
        try {
            s = new Socket(address, port);
            dataIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            dataOut = new PrintWriter(s.getOutputStream(), true);
            view.appendResponse("Conectado al servidor.");
            view.setSendButtonEnabled(true); // habilitamos el boton al conectarse
        } catch (IOException e) {
            view.appendResponse("Error de conexion: " + e.getMessage());
            view.setSendButtonEnabled(false); // aseguramos que el boton permanezca deshabilitado si falla
        }
    }

    // creamos el metodo que permita comunicarse con el boton
    private void handleSendButton(ActionEvent e) {
        String numberText = view.getNumberText();
        if (numberText != null && !numberText.trim().isEmpty()) {
            try {
                int number = Integer.parseInt(numberText.trim());
                dataOut.println(number); // enviamos el número como String
                view.appendResponse("Enviado: " + number);
                numberCount++;

                if (numberCount >= 10) {
                    String response = dataIn.readLine(); // leemos la respuesta del servidor
                    view.appendResponse("Respuesta del servidor: " + response);

                    // cerramos la conexion después de recibir la respuesta
                    dataOut.close();
                    dataIn.close();
                    s.close();
                    view.appendResponse("Conexion cerrada.");
                    numberCount = 0; // reiniciamos el contador
                }
            } catch (NumberFormatException ex) {
                view.appendResponse("Error, por favor introduzca un numero valido.");
            } catch (IOException ex) {
                view.appendResponse("Error de E/S: " + ex.getMessage());
            }
        }
    }
}
