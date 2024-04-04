package correto;

public class Quadrado extends Figura {

    private final double tamanho;

    public Quadrado(double tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public double calcularArea() {
        return tamanho * tamanho;
    }
}