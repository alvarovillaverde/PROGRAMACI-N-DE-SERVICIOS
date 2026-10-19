package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor3 {
    public static void main(String[] args) {
        int puerto = 6000;
        ServicioMayusculas servicio = new ServicioMayusculas(); // Instanciamos la lógica

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor a la escucha en el puerto " + servidor.getLocalPort() + "...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde: " + cliente.getInetAddress());

            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            boolean conectado = true;

            while (conectado) {
                String mensajeRecibido = flujoEntrada.readUTF();

                if (mensajeRecibido.equalsIgnoreCase("quit")) {
                    conectado = false;
                    System.out.println("El cliente ha cerrado la sesión.");
                } else {
                    String mensajeProcesado = servicio.transformarAMayusculas(mensajeRecibido);

                    flujoSalida.writeUTF(mensajeProcesado);
                    flujoSalida.flush();
                }
            }

            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}