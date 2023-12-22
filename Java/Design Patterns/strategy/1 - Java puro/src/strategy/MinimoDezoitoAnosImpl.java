package src.strategy;

import src.domain.Usuario;

public class MinimoDezoitoAnosImpl implements ICadastro {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getIdade() < 18) {
            throw new RuntimeException("Usuário não pode ser menor de idade!!!");
        }
    }
}