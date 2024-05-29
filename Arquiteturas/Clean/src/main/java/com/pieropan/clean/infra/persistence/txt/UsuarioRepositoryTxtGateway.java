package com.pieropan.clean.infra.persistence.txt;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioRepositoryGateway;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioRepositoryTxtGateway implements UsuarioRepositoryGateway {

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("usuario.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] dados = line.split(";");
                usuarios.add(new Usuario(Long.parseLong(dados[0]), dados[1], dados[2], dados[3]));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }

    private Long obterUltimoId() {
        try (BufferedReader bf = new BufferedReader(new FileReader("usuario.txt"))) {
            String line;
            String ultimoId = "0";
            while ((line = bf.readLine()) != null) {
                ultimoId = line.split(";")[0];
            }
            return Long.parseLong(ultimoId);
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0L;
        }
    }

    @Override
    public Usuario save(Usuario usuario) {
        Long novoId = obterUltimoId() + 1;
        try (FileWriter fw = new FileWriter("usuario.txt", true)) {
            String usuarioStr = String.format("%s;%s;%s;%s%n", novoId, usuario.nome(), usuario.email(), usuario.senha());
            fw.write(usuarioStr);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Usuario.toUsuario(usuario, novoId);
    }
}