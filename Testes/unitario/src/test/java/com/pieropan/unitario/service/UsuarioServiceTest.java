package com.pieropan.unitario.service;

import com.pieropan.unitario.dto.UsuarioRequest;
import com.pieropan.unitario.dto.UsuarioResponse;
import com.pieropan.unitario.entity.Usuario;
import com.pieropan.unitario.excecao.MenorIdadeException;
import com.pieropan.unitario.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve retornar uma lista com apenas um usuário")
    public void deveRetornarUmaListaComUmUsuario() {
        Usuario usuario = new Usuario(1L, "Matheus", "matheus@dev.com", "dsjndfjnfd", 18);
        Mockito.when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));
        List<UsuarioResponse> usuarios = usuarioService.buscarTodos();

        Assertions.assertEquals(1, usuarios.size());
    }

    @Test
    @DisplayName("Deve lançar exceção com usuário menor de idade")
    public void deveLancarExcecaoQuandoUsuarioTiverIdadeMenorQueDezoito() {
        UsuarioRequest usuarioRequest = new UsuarioRequest("Matheus", "matheus@dev.com", "qualquercoisa", 17);
        Assertions.assertThrows(MenorIdadeException.class, () -> usuarioService.salvar(usuarioRequest));
    }
}