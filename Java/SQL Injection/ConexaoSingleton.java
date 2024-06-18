import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConexaoSingleton {

    private static ConexaoSingleton instance;

    private final Connection connection;

    private ConexaoSingleton() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/clean",
                    "postgres", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConexaoSingleton getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConexaoSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}