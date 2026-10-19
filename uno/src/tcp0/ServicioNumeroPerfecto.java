package tcp0;

public class ServicioNumeroPerfecto {

    public boolean esNumeroPerfecto(int numero) {
        if (numero <= 0) {
            return false;
        }

        int sumaDivisores = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }

        return sumaDivisores == numero;
    }
}