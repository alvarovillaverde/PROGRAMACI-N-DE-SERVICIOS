package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) {
        int puerto = 6000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Escuchando en el puerto " + servidor.getLocalPort());

            Socket cliente1 = servidor.accept();
            System.out.println("Cliente 1 conectado: " + cliente1.getInetAddress());

            DataInputStream flujoEntrada = new DataInputStream(cliente1.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente1.getOutputStream());

            flujoSalida.writeUTF("Saludos al cliente desde el servidor");
            flujoSalida.flush();

            boolean conectado = true;

            while (conectado) {
                String mensaje = flujoEntrada.readUTF();

                if (mensaje.equalsIgnoreCase("quit")) {
                    conectado = false;
                    System.out.println("\nEl cliente ha solicitado finalizar la comunicación.");
                } else {
                    System.out.println("Cliente dice: " + mensaje);
                }
            }

            // Cierre de flujos y sockets
            flujoEntrada.close();
            flujoSalida.close();
            cliente1.close();

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}