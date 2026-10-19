package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try (Socket cliente = new Socket(host, puerto);
             Scanner sc = new Scanner(System.in)) {

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            System.out.println("Servidor: " + flujoEntrada.readUTF());

            boolean ejecutando = true;

            while (ejecutando) {
                System.out.print("Escribe un mensaje (o 'quit' para salir): ");
                String texto = sc.nextLine();

                flujoSalida.writeUTF(texto);
                flujoSalida.flush();

                if (texto.equalsIgnoreCase("quit")) {
                    ejecutando = false;
                    System.out.println("Se acabó la conexión.");
                }
            }

            // Cierre de flujos
            flujoEntrada.close();
            flujoSalida.close();

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}