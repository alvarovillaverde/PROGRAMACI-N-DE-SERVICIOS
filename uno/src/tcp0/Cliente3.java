package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente3 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try (Socket cliente = new Socket(host, puerto);
             Scanner sc = new Scanner(System.in)) {

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            boolean ejecutando = true;
            System.out.println("Conectado. Escribe texto para pasarlo a mayúsculas ('quit' para salir):");

            while (ejecutando) {
                System.out.print("> ");
                String texto = sc.nextLine();

                flujoSalida.writeUTF(texto);
                flujoSalida.flush();

                if (texto.equalsIgnoreCase("quit")) {
                    ejecutando = false;
                    System.out.println("Desconectando...");
                } else {
                    String respuesta = flujoEntrada.readUTF();
                    System.out.println("Respuesta Servidor: " + respuesta);
                }
            }

            flujoEntrada.close();
            flujoSalida.close();

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}