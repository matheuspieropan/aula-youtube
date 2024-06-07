public class RecordPatterns {

    /**
     * Implementado no Java 21
     */
    public static void main(String[] args) {
        Object obj = new Pessoa("Matheus", 27);
        antes(obj);
        demonstracao(obj);
    }

    private static void antes(Object obj) {
        if (obj instanceof Pessoa pessoa) {
            System.out.printf("Nome: %s\n", pessoa.nome);
            System.out.printf("Idade: %s\n", pessoa.idade);
        }
    }

    private static void demonstracao(Object obj) {
        if (obj instanceof Pessoa(String nome, int idade)) {
            System.out.printf("Nome: %s\n", nome);
            System.out.printf("Idade: %s", idade);
        }
    }

    private record Pessoa(String nome, int idade) {
    }
}