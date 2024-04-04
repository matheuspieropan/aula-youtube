package errado;

public class Main {

    public static void main(String[] args) {

        Retangulo retangulo = new Quadrado();

        retangulo.setLargura(4);
        retangulo.setAltura(6);

        System.out.println(retangulo.calcularArea());
    }
}