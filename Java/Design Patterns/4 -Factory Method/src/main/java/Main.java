import factory.DiaDaSemana;
import factory.DiaSemanaFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe número do dia da semana: ");

        DiaDaSemana diaDaSemana = DiaSemanaFactory.obterDiaSemana(scanner.nextInt());
        System.out.println(diaDaSemana.diaSemanaPorTexto());
    }
}