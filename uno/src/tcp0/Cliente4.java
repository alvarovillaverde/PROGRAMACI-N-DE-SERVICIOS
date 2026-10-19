package tcp0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente4 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        ServicioLogicaCliente servicioLogicaCliente = new ServicioLogicaCliente();

        try (Socket cliente = new Socket(host, puerto);
             Scanner sc = new Scanner(System.in)) {

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            boolean ejecutando = true;
            System.out.println("Conectado al servidor de Números Perfectos.");
            System.out.println("Introduce enteros positivos para comprobar (Introduce 0 para salir):");

            while (ejecutando) {
                int numero = -1;

                while (numero < 0) {
                    System.out.print("\n Introduce un número (0 para salir): ");
                    numero = servicioLogicaCliente.filtro(sc);
                }

                flujoSalida.writeInt(numero);
                flujoSalida.flush();

                if (numero == 0) {
                    ejecutando = false;
                    System.out.println("Finalizando conexión...");
                } else {
                    String respuesta = flujoEntrada.readUTF();
                    System.out.println("Respuesta del servidor: " + respuesta);
                }
            }

            flujoEntrada.close();
            flujoSalida.close();

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
