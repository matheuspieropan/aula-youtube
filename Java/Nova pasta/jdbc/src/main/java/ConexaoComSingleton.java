import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConexaoComSingleton {

    private static ConexaoComSingleton conexaoComSingleton;

    private static Connection connection;

    private ConexaoComSingleton() {
        try {
            Class.forName("org.postgresql.Driver");
            String usuario = "postgres";
            String senha = "123";
            String url = "jdbc:postgresql://localhost:5432/aulajdbc";
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (Objects.isNull(conexaoComSingleton)) {
            conexaoComSingleton = new ConexaoComSingleton();
        }
        return connection;
    }
}