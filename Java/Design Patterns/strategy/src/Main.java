package src;

import src.domain.Usuario;

public class Main {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Matheus", 27);

        if (usuario.getNome().length() < 3) {
            throw new RuntimeException("Nome não pode ter menos que 3 caracteres");
        }

        if (usuario.getNome().length() > 15) {
            throw new RuntimeException("Nome não pode ter mais que 15 caracteres");
        }

        if (usuario.getIdade() < 18) {
            throw new RuntimeException("Usuário não pode ser menor de idade!!!");
        }

        if (usuario.getIdade() > 60) {
            throw new RuntimeException("Usuário não ter mais que 60 anos");
        }

        cadastrar(usuario);
    }

    private static void cadastrar(Usuario usuario) {
        // simulando persistência no banco de dados
        System.out.printf("Usuário %s salvo com sucesso!", usuario.getNome());
    }
}