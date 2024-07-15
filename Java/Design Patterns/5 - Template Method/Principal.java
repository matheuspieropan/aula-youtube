public class Principal {

    public static void main(String[] args) {
        Bebida bebida = new Cafe();
        try {
            bebida.prepararBebida();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}