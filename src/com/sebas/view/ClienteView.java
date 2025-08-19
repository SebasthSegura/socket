/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebas.view;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;


/**
 *
 * @author sebath
 */
public class ClienteView extends JFrame{
    
    // creamos las varaibles a usar en nuestra vista que usara el usuario
    private JTextField numberField;
    private JButton sendButton;
    private JTextArea responseArea;
    
    // creamos el constructor para la clase ClienteView para la vista de este mismo
    public ClienteView(){
        super("Clienete de Numeros");
        
        // usamos AWT para para el layout 
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // componentes de swing
        numberField = new JTextField(10);
        sendButton = new JButton("Enviar Número");
        responseArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(responseArea);
        responseArea.setEditable(false);
        
        // añadimos los componentes al frame 
        add(new JLabel("Introduce 10 numeros:"));
        add(numberField);
        add(sendButton);
        add(scrollPane); // añadimos un scroll al  text area
        
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    // creamos el metodo para habilitar/deshabilitar el botón de envio
    public void setSendButtonEnabled(boolean enabled) {
        sendButton.setEnabled(enabled);
    }
    
    // creamos el metodo que escuche al boton
    public void addSendButtonListener(ActionListener listener){
        sendButton.addActionListener(listener);
    }
    
    // añadimos el metodo para obtener el numero del TextField
    public String getNumberText(){
        return numberField.getText();
    }
    
    // creamos el metodo para añadir la respuesta al text area
    public void appendResponse(String response){
        responseArea.append(response + "\n");
    }
            
}
