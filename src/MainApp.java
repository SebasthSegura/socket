import com.sebas.view.ClienteView;
import com.sebas.view.ServerView;
import com.sebas.controller.ClienteController;
import com.sebas.controller.ServerController;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sebath
 */
public class MainApp {
    public static void main(String[] args) {
        // creamos un nuevo hilo que permitira iniciar el el servidor
        new Thread(() -> {
            SwingUtilities.invokeLater(() -> {
                ServerView serverView = new ServerView();
                new ServerController(serverView);
                serverView.setVisible(true);
            });
        }).start();

        // esperamos a que se inicie el servidor correctamente
        try {
            Thread.sleep(100000); // esperamos 100 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // iniciamos el hilo para el cliente
        new Thread(() -> {
            SwingUtilities.invokeLater(() -> {
                ClienteView clienteView = new ClienteView();
                ClienteController clienteController = new ClienteController(clienteView);
                clienteView.setVisible(true);
                clienteController.start();
            });
        }).start();
    }
}
