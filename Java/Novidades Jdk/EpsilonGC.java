public class EpsilonGC {
    /**
     * Implementado no Java 11
     * java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC EpsilonGC.java
     */
    public static void main(String[] args) {
        System.out.println("Início");

        int quantidade = 0;
        while (quantidade < 10) {
            byte[] bytes = new byte[1024 * 1024 * 1024];
            quantidade++;
        }
        System.out.println("Fim");
    }
}