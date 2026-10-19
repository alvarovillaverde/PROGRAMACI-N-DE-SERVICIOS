package tcp0;

import java.util.Scanner;

public class ServicioLogicaCliente {
    public int filtro(Scanner sc) {
        int numero = -1;
        if (sc.hasNextInt()) {
                        numero = sc.nextInt();
                        if (numero < 0) {
                            System.out.println("[Error] Debe ser un entero positivo o 0.");
                        }
                    } else {
                        System.out.println("[Error] Entrada no válida. Introduce un número entero.");
                        sc.next();
                    }
        return numero;
    }
}
