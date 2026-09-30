package intro;

import java.io.*;
import java.net.*;

public class Ejemplo2URL {

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.google.com/?hl=es");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in;
        try {
            // Abre una conexión al objeto URL y devuelve un InputStream para leer los datos
            InputStream inputStream = url.openStream();
            
            // Envuelve el flujo de entrada para poder leer el texto línea por línea
            in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            // Lee el contenido línea a línea hasta llegar al final (null)
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Cierra el flujo de entrada
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // main

} // Ejemplo2URL