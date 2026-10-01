package tcp0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor0 {
    public static void main(String[] args) {
        int port = 6000; // Puerto

        try {
            ServerSocket serverS = new ServerSocket(port);
            System.out.println("Escuchando en " + serverS.getLocalPort());

            Socket cliente1 = serverS.accept(); // esperando a un cliente
            // realizar acciones con cliente1

            Socket cliente2 = serverS.accept(); // esperando a otro cliente
            // realizar acciones con cliente2

            serverS.close(); // cierro socket servidor

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
