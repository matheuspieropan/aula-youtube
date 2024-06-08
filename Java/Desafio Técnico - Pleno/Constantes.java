public class Constantes {

    public static final String INSERT_CLIENTE = " INSERT INTO cliente (nome, sobrenome, idade) VALUES (?, ?, ?)";
    public static final String INSERT_ENDERECO = " INSERT INTO endereco (logradouro, numero, bairro, id_cliente) VALUES (?, ?, ?, ?);";
}