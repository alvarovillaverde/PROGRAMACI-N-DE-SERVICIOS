package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor4 {
    public static void main(String[] args) {
        int puerto = 6000;
        ServicioNumeroPerfecto servicio = new ServicioNumeroPerfecto();

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor a la escucha en el puerto " + servidor.getLocalPort() + "...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde: " + cliente.getInetAddress());

            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            boolean conectado = true;

            while (conectado) {
                int numeroRecibido = flujoEntrada.readInt();

                if (numeroRecibido == 0) {
                    conectado = false;
                    System.out.println("El cliente ha enviado 0. Cerrando sesión...");
                } else {
                    System.out.println("Comprobando número recibido: " + numeroRecibido);

                    boolean esPerfecto = servicio.esNumeroPerfecto(numeroRecibido);

                    String respuesta;
                    if (esPerfecto) {
                        respuesta = "El número " + numeroRecibido + " ES perfecto.";
                    } else {
                        respuesta = "El número " + numeroRecibido + " NO es perfecto.";
                    }

                    flujoSalida.writeUTF(respuesta);
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
