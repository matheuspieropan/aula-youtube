import domain.Pessoa;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        new Pessoa(null, null, LocalDate.of(1996, 11, 12), 0);
        new Pessoa("Matheus", null, null, 0);

        Pessoa pessoaSoComNome = new Pessoa.PessoaBuilder()
                .nome("Matheus")
                .build();
        System.out.println(pessoaSoComNome);

        Pessoa pessoaSoComDataNascimento = new Pessoa.PessoaBuilder()
                .dataNascimento(LocalDate.of(1996, 11, 12))
                .build();
        System.out.println(pessoaSoComDataNascimento);

        Pessoa pessoaComOsDois = new Pessoa.PessoaBuilder()
                .nome("Matheus")
                .dataNascimento(LocalDate.of(1996, 11, 12))
                .build();
        System.out.println(pessoaComOsDois);


        Pessoa pessoaCompleta = new Pessoa.PessoaBuilder()
                .nome("Matheus")
                .sobrenome("Pieropan")
                .idade(27)
                .dataNascimento(LocalDate.of(1996, 11, 12))
                .build();
        System.out.println(pessoaCompleta);
    }
}