/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebas.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sebath
 */
public class ServerView extends JFrame{
        
    // creamos las varaibles a usar en nuestra vista que usara el usuario
    private JButton startButton;
    private JTextArea statusArea;
    
    // creamos el constructor para la clase ServerView para la vista de este mismo
    public ServerView(){
        super("Servidor de Numeros");
        
        // usamos AWT para para el layout 
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //  componentes de swing
        startButton = new JButton("Iniciar Servidor");
        statusArea = new JTextArea(10, 30);
        statusArea.setEditable(false);
        
        // añadimos los componentes al frame 
        this.add(startButton);
        this.add(new JScrollPane(statusArea)); // añadimos un scroll al  text area
    }
    
    // creamos el metodo que escuche al boton
    public void addStartButtonListener(ActionListener listener){
        startButton.addActionListener(listener);
    }

    // creamos el metodo para añadir el status al text area
    public void appendStatus(String status){
        statusArea.append(status + "\n");
    }
}
