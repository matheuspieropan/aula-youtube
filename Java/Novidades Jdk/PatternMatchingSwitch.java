public class PatternMatchingSwitch {

    /**
     * Implementado no Java 17 como prévia e versão padrão na 21
     */
    public static void main(String[] args) {
        Object obj = new Pessoa("Matheus", 27);
        antes(obj);
        depois(obj);
    }

    private static void antes(Object obj) {
        switch (obj) {
            case Pessoa pessoa -> {
                System.out.println(pessoa.nome());
                System.out.println(pessoa.idade());
            }
            default -> System.out.println("Tipo não encontrado!");
        }
    }

    private static void depois(Object obj) {
        switch (obj) {
            case Pessoa(String nome, int idade) -> {
                System.out.println(nome);
                System.out.println(idade);
            }
            case Integer i -> System.out.println("É um número inteiro!");
            default -> System.out.println("Tipo não encontrado!");
        }
    }

    private record Pessoa(String nome, int idade) {
    }
}