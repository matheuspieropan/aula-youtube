package src;

import src.domain.Usuario;
import src.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class MainStrategy {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Lucas", 27);

        List<ICadastro> validacoes = new ArrayList<>();

        validacoes.add(new MinimoTresCaracteresImpl());
        validacoes.add(new MaximoQuinzeCaracteresImpl());
        validacoes.add(new MinimoDezoitoAnosImpl());
        validacoes.add(new MaximoSessentaAnosImpl());

        validacoes.forEach(validacao -> validacao.validar(usuario));

        cadastrar(usuario);
    }

    private static void cadastrar(Usuario usuario) {
        // simulando persistência no banco de dados
        System.out.printf("Usuário %s salvo com sucesso!", usuario.getNome());
    }
}