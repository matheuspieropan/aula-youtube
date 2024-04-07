package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DataBaseConnection {

    private static DataBaseConnection instace;

    private final Connection connection;

    private DataBaseConnection() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "123");
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao se conectar com banco de dados!");
        }
    }

    public static DataBaseConnection getInstance() {
        if (Objects.isNull(instace)) {
            instace = new DataBaseConnection();
        }
        return instace;
    }

    public Connection connection() {
        return connection;
    }
}