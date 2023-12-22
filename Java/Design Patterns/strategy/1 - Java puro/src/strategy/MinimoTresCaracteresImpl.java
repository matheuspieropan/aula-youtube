package src.strategy;

import src.domain.Usuario;

public class MinimoTresCaracteresImpl implements ICadastro {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getNome().length() < 3) {
            throw new RuntimeException("Nome não pode ter menos que 3 caracteres");
        }
    }
}