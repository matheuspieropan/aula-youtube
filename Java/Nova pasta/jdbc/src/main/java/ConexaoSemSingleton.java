import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSemSingleton {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String usuario = "postgres";
            String senha = "123";
            String url = "jdbc:postgresql://localhost:5432/aulajdbc";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}