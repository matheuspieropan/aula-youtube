package domain;

public class Pessoa implements Comparable<Pessoa> {

    private String nome;

    private Integer idade;

    public Integer getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return this.getNome().compareTo(pessoa.getNome());
    }
}