import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        System.out.println("""
                ---- Escolha uma opçao ---
                1 - Criar usuário
                2 - Listar usuário
                3 - Sair
                """);

        invocarOpcaoSelecionada(scanner.next());
    }

    private static void invocarOpcaoSelecionada(String opcao) {
        switch (opcao) {
            case "1" -> realizarCadastro();
            case "2" -> listarUsuario();
        }
    }

    private static void realizarCadastro() {
        try {
            Connection connection = ConexaoSingleton.getInstance().getConnection();
            connection.setAutoCommit(false);

            int idCliente = criarCliente(connection);
            criarEndereco(connection, idCliente);
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("Não foi possível inserir registro!");
        }
        exibirMenu();
    }

    private static int criarCliente(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Constantes.INSERT_CLIENTE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "Matheus");
            statement.setString(2, "Pieropan");
            statement.setInt(3, 27);
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        }
    }

    private static void criarEndereco(Connection connection, int idCliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Constantes.INSERT_ENDERECO)) {
            statement.setString(1, "Rua alguma coisa");
            statement.setInt(2, 10);
            statement.setString(3, "Bairro XPTO");
            statement.setInt(4, idCliente);
            statement.executeUpdate();
        }
    }

    private static void listarUsuario() {
        // implementar
    }
}