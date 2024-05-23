package com.pieropan.clean.infra.persistence.jpa;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioRepositoryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioRepositoryJpaGateway implements UsuarioRepositoryGateway {

    private final UsuarioRepository usuarioRepository;

    public UsuarioRepositoryJpaGateway(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return Usuario.toUsuario((List<UsuarioEntity>) usuarioRepository.findAll());
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = Usuario.toUsuarioEntity(usuario);
        return Usuario.toUsuario(usuarioRepository.save(usuarioEntity));
    }
}