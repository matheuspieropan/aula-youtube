import connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Connection connection = DataBaseConnection.getInstance().connection();
            PreparedStatement pstm = connection.prepareStatement("SELECT nome, email FROM usuario");
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                usuarios.add(new Usuario(nome, email));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        usuarios.forEach(usuario -> System.out.println(usuario.getNome() + " " + usuario.getEmail()));
    }
}