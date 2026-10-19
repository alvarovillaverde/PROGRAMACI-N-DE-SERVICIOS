package tcp0;

public class ServicioMayusculas {
    
    public String transformarAMayusculas(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.toUpperCase();
    }
}