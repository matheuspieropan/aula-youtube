import util.Constante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        executar(true);
    }

    private static void executar(boolean comSingleton) {
        LocalDateTime inicio = LocalDateTime.now();

        int contador = 0;
        while (contador < 10000) {
            salvarPessoa(comSingleton);
            contador++;
        }

        String segundos = String.valueOf(Duration.between(inicio, LocalDateTime.now()).getSeconds());
        System.out.println("Tempo de execução em segundos: " + segundos);
    }

    private static void salvarPessoa(boolean comSingleton) {
        try {
            Connection connection = comSingleton ? ConexaoComSingleton.getConnection()
                    : ConexaoSemSingleton.getConnection();

            PreparedStatement statement = connection.prepareStatement(Constante.INSERT_PESSOA);

            statement.setString(1, "Matheus");
            statement.setString(2, "matheus@gmail.com");
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}