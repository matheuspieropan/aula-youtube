package com.pieropan.clean.infra.persistence.txt;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioRepositoryGateway;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
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
}