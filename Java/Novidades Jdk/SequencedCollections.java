import java.util.Arrays;
import java.util.List;

public class SequencedCollections {

    /**
     * Implementado no Java 21
     */
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Matheus", "Marcos", "Lucas", "João");
        antes(nomes);
        depois(nomes);
        System.out.println(nomes.reversed());
    }

    private static void antes(List<String> nomes) {
        System.out.printf("Primeiro: %s\n", nomes.get(0));
        System.out.printf("Último: %s\n", nomes.get(nomes.size() - 1));
    }

    private static void depois(List<String> nomes) {
        System.out.printf("Primeiro: %s\n", nomes.getFirst());
        System.out.printf("Último: %s\n", nomes.getLast());
    }
}