package tcp0;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente0 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000; // puerto remoto

        // ABRIR SOCKET Y GESTIONAR CIERRE AUTOMÁTICO
        try (Socket cliente = new Socket(host, puerto)) { // conecta
            
            InetAddress inet = cliente.getInetAddress();

            System.out.println("Puerto local: " + cliente.getLocalPort());
            System.out.println("Puerto Remoto: " + cliente.getPort());
            System.out.println("Host Remoto: " + inet.getHostName());
            System.out.println("IP Host Remoto: " + inet.getHostAddress());

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}