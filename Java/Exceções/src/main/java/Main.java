import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        explicacaoExcecoes();
        try {
            excecaoChecada();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void explicacaoExcecoes() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite sua idade: ");
            scanner.nextInt();

            System.out.print("Digite sua data de nascimento formato (dd/MM/yyyy): ");
            String data = scanner.next();

            LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyy"));

        } catch (InputMismatchException ex) {
            System.out.println("Erro. Não é possível digitar letras no campo idade");
        } catch (DateTimeParseException ex) {
            System.out.println("Você digitou a data num formato inválido!!!");
        }
    }

    public static void excecaoChecada() throws FileNotFoundException {
        new FileInputStream("exemploo.txt");
    }
}