package src.strategy;

import src.domain.Usuario;

public class MaximoQuinzeCaracteresImpl implements ICadastro {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getNome().length() > 15) {
            throw new RuntimeException("Nome não pode ter mais que 15 caracteres");
        }
    }
}