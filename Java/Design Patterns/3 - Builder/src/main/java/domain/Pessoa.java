package domain;

import java.time.LocalDate;

public class Pessoa {

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private Integer idade;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                '}';
    }

    public Pessoa(String nome, String sobrenome, LocalDate dataNascimento, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public static class PessoaBuilder {

        private String nome;

        private String sobrenome;

        private LocalDate dataNascimento;

        private Integer idade;

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder dataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public PessoaBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(nome, sobrenome, dataNascimento, idade);
        }
    }
}