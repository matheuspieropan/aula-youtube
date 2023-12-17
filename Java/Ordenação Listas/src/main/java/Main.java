import domain.Pessoa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = criarListaPessoa();

        Collections.sort(pessoas);
        System.out.println(pessoas);

        pessoas = criarListaPessoa();

        List<Pessoa> pessoaOrdenada = pessoas.stream().filter(pessoa -> pessoa.getIdade() > 30)
                .sorted().collect(Collectors.toList());

        System.out.println(pessoaOrdenada);

        pessoas = criarListaPessoa();

        List<Pessoa> pessoasOrdenadasDois = pessoas.stream().sorted(
                Comparator.comparing(Pessoa::getIdade)).collect(Collectors.toList());

        System.out.println(pessoasOrdenadasDois);
    }

    private static List<Pessoa> criarListaPessoa() {
        return Arrays.asList(
                new Pessoa("Matheus", 30),
                new Pessoa("Davi", 22),
                new Pessoa("Samuel", 33),
                new Pessoa("João", 5),
                new Pessoa("Tiago", 92));
    }
}