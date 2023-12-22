package src.strategy;

import src.domain.Usuario;

public class MaximoSessentaAnosImpl implements ICadastro {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getIdade() > 60) {
            throw new RuntimeException("Usuário não ter mais que 60 anos");
        }
    }
}