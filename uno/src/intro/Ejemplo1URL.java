package intro;

import java.net.*;

public class Ejemplo1URL {

    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL:");
            url = new URL("http://docs.oracle.com/");
            Visualizar(url);

            System.out.println("Otro constructor simple para una URL:");
            url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
            Visualizar(url);

            System.out.println("Const. para protocolo +URL +directorio:");
            url = new URL("http", "docs.oracle.com", "/javase/7");
            Visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto + directorio:");
            url = new URL("http", "docs.oracle.com", 80, "/javase/7");
            Visualizar(url);

            System.out.println("Constructor para un objeto URL y un directorio:");
            URL urlBase = new URL("http://docs.oracle.com/");
            url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
            Visualizar(url);

        } catch (MalformedURLException e) {
            System.out.println(e);
        }
    } // main

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\ttgetProtocol(): " + url.getProtocol());
        System.out.println("\ttgetHost(): " + url.getHost());
        System.out.println("\ttgetPort(): " + url.getPort());
        System.out.println("\ttgetFile(): " + url.getFile());
        System.out.println("\ttgetUserInfo(): " + url.getUserInfo());
        System.out.println("\ttgetPath(): " + url.getPath());
        System.out.println("\ttgetAuthority(): " + url.getAuthority());
        System.out.println("\ttgetQuery(): " + url.getQuery());
        System.out.println("==================================================");
    } // Visualizar

} // Ejemplo1URL