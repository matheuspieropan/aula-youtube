package com.pieropan.unitario.service;

import com.pieropan.unitario.dto.UsuarioRequest;
import com.pieropan.unitario.dto.UsuarioResponse;
import com.pieropan.unitario.entity.Usuario;
import com.pieropan.unitario.excecao.MenorIdadeException;
import com.pieropan.unitario.excecao.SenhaInvalidaException;
import com.pieropan.unitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> buscarTodos() {
        return UsuarioResponse.toUsuarioResponse((List<Usuario>) usuarioRepository.findAll());
    }

    public UsuarioResponse salvar(UsuarioRequest usuario) {
        if (usuario.idade() < 18) {
            throw new MenorIdadeException("Não é permitido o cadastro para menor de idade!");
        }

        if(usuario.senha().contains("123")){
            throw new SenhaInvalidaException("Senha não permitida!");
        }

        Usuario entity = usuarioRepository.save(UsuarioRequest.toUsuario(usuario));
        return UsuarioRequest.toUsuarioRequest(entity);
    }
}