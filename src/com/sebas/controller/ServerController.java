/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebas.controller;

import com.sebas.model.ProcessorNumber;
import com.sebas.view.ServerView;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;



/**
 *
 * @author sebath
 */
public class ServerController {
    
    // declaramos las variables dela vista, el socket y el modelo de numero
    private ServerSocket sS;
    private ServerView view;
    private ProcessorNumber processor;
    private final ExecutorService clientPool = Executors.newFixedThreadPool(10); // Pool de hilos para clientes

    // añadimos el constructor principal del controlador del servidor
    public ServerController(ServerView view) {
        this.view = view;
        this.processor = new ProcessorNumber();
        this.view.addStartButtonListener(this::handleStartButton);
    }

    private void handleStartButton(ActionEvent e) {
        // ejecutamos el servidor en un hilo diferente para no bloquear la GUI
        new Thread(() -> {
            try {
                sS = new ServerSocket(6000); // Puerto cambiado a 6000
                view.appendStatus("Servidor escuchando en el Puerto 6000...");

                while (true) {
                    Socket clienteSocket = sS.accept();
                    view.appendStatus("Cliente Conectado desde " + clienteSocket.getInetAddress());
                    clientPool.execute(() -> handleClient(clienteSocket));
                }
            } catch (IOException ex) {
                view.appendStatus("Error del servidor: " + ex.getMessage());
            }
        }).start();
    }
    
    private void handleClient(Socket clienteSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
        ) {
            processor.clearNumbers();
            int numberRecived = 0;
            String inputLine;

            while (numberRecived < 10 && (inputLine = in.readLine()) != null) {
                try {
                    int number = Integer.parseInt(inputLine.trim());
                    processor.addNumber(number);
                    numberRecived++;
                } catch (NumberFormatException e) {
                    // ignoramos las entradas no validas
                }
            }

            int largest = processor.getNumberLargest();
            int smallest = processor.getNumberSmallest();
            int sum = processor.getSumAllNumbers();

            String response = String.format("El numero MAYOR es %d, el numero menor es %d, la suma de todos los numeros es %d", largest, smallest, sum);
            out.println(response);

            view.appendStatus("Procesando y enviando la respuesta al cliente.");
        } catch (IOException e) {
            view.appendStatus("Error de E/S con el cliente: " + e.getMessage());
        } finally {
            try {
                if (!clienteSocket.isClosed()) {
                    clienteSocket.close();
                }
                view.appendStatus("Conexion con el cliente cerrada");
            } catch (IOException e) {
                // ignoramos lo capturado
            }
        }
    }
}
