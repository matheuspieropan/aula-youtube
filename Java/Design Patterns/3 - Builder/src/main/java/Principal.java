import domain.Pessoa;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        int N = 2;
        int contador = 1;

        while (contador <= 10) {
            String resultado = String.valueOf((N * contador));
            System.out.println(String.valueOf(N).concat(" x "
                    .concat(String.valueOf((contador)))
                    .concat(" = ")
                    .concat(resultado)));
            contador++;
        }
    }
}