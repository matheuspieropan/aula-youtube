public class PatternMatchingIf {

    /**
     * Implementado no Java 14 como prévia e recurso padrão no 16
     */
    public static void main(String[] args) {
        Object obj = new Pessoa("Matheus", 27);
        antes(obj);
        depois(obj);
    }

    private static void antes(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            System.out.printf("Nome: %s\n", pessoa.nome());
            System.out.printf("Idade: %s\n", pessoa.idade());
        }
    }

    private static void depois(Object obj) {
        if (obj instanceof Pessoa pessoa) {
            System.out.printf("Nome: %s\n", pessoa.nome());
            System.out.printf("Idade: %s\n", pessoa.idade());
        }

        if (obj instanceof Pessoa pessoa && pessoa.idade() >= 18) {
            System.out.println("Maior de idade!");
        }
    }

    private record Pessoa(String nome, int idade) {
    }
}