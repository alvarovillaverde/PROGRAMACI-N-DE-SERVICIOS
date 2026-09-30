package intro;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejemplo2URLcon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            URL url = new URL("http://localhost/vernombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            System.out.println("Dame el nombre");
            String nombre = sc.nextLine();
            System.out.println("Dame el apellido");
            String apellidos = sc.nextLine();

            StringBuilder builder = new StringBuilder();

            builder.append("nombre=").append(nombre).append("&apellidos=").append(apellidos);
            String cadena = builder.toString();

            //ESCRIBIR EN LA URL
            PrintWriter output = new PrintWriter
                                (conexion.getOutputStream());
            output.write(cadena);
            output.close(); //cerrar flujo

            //LEER DE LA URL
            BufferedReader reader = new BufferedReader
                                (new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();//cerrar flujo

        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
        sc.close();
    }//main
}//Ejemplo2urlCon