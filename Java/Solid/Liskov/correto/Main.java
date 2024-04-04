package correto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Retangulo(8, 4));
        figuras.add(new Quadrado(5));

        figuras.forEach(f -> System.out.println(f.calcularArea()));
    }
}