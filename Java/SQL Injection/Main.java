import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    /*
    ' OR '1'='1
    SELECT * FROM usuario_entity WHERE email = '' AND senha = '' OR '1'='1'
    SELECT * FROM usuario_entity WHERE email = '' AND senha = ''' OR ''1''=''1'
     */
    public static void main(String[] args) {
        errado();
        certo();
    }

    private static void errado() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        try {
            Connection connection = ConexaoSingleton.getInstance().getConnection();
            String query = String.format("SELECT * FROM usuario_entity WHERE email = '%s' AND senha = '%s'", email, senha);
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    System.out.println("Encontrou resultado!!!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void certo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        try {
            Connection connection = ConexaoSingleton.getInstance().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM usuario_entity WHERE email = ? AND senha = ?")) {
                statement.setString(1, email);
                statement.setString(2, senha);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    System.out.println("Encontrou resultado!!!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}