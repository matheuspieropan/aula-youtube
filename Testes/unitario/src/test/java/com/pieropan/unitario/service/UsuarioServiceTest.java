package com.pieropan.unitario.service;

import com.pieropan.unitario.dto.UsuarioRequest;
import com.pieropan.unitario.dto.UsuarioResponse;
import com.pieropan.unitario.entity.Usuario;
import com.pieropan.unitario.excecao.MenorIdadeException;
import com.pieropan.unitario.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario(1L, "Matheus", "matheus@dev.com", "dsjndfjnfd", 18);
        lenient().when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        lenient().when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));
    }

    @Test
    @DisplayName("Deve retornar uma lista com apenas um usuário")
    public void deveRetornarUmaListaComUmUsuario() {
        List<UsuarioResponse> usuarios = usuarioService.buscarTodos();

        assertEquals(1, usuarios.size());

        verify(usuarioRepository).findAll();
        verifyNoMoreInteractions(usuarioRepository);
    }

    @Test
    @DisplayName("Deve lançar exceção com usuário menor de idade")
    public void deveLancarExcecaoQuandoUsuarioForMenorDeIdade() {
        assertThrows(MenorIdadeException.class, () -> usuarioService.salvar(criaUsuarioRequest()));
        verifyNoInteractions(usuarioRepository);
    }

    @Test
    @DisplayName("Deve buscar usuário por Id")
    public void deveBuscarUsuarioPorId() {
        UsuarioResponse usuarioResponse = usuarioService.buscarPorId(1L);
        assertNotNull(usuarioResponse);
    }

    private UsuarioRequest criaUsuarioRequest() {
        return new UsuarioRequest("Matheus", "matheus@dev.com", "qualquercoisa", 17);
    }
}