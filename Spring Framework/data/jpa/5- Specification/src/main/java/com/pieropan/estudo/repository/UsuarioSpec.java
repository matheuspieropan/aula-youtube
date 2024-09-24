package com.pieropan.estudo.repository;

import com.pieropan.estudo.UsuarioFilter;
import com.pieropan.estudo.entity.Usuario;
import com.pieropan.estudo.entity.Usuario_;
import com.pieropan.estudo.enums.StatusEnum;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Objects;

public class UsuarioSpec {

    private static Specification<Usuario> porNome(String nome) {

        return (root, query, builder) -> {

            if (Objects.nonNull(nome)) {
                return builder.equal(root.get(Usuario_.NOME), nome);
            }

            return null;
        };
    }

    private static Specification<Usuario> nascidoAposAno(LocalDate dataNascimento) {

        return (root, query, builder) -> {

            if (Objects.nonNull(dataNascimento)) {
                return builder.greaterThan(root.get(Usuario_.DATA_NASCIMENTO), dataNascimento);
            }

            return null;
        };
    }

    private static Specification<Usuario> statusDiferenteDe(StatusEnum status) {

        return (root, query, builder) -> {

            if (Objects.nonNull(status)) {
                return builder.notEqual(root.get(Usuario_.STATUS), status);
            }

            return null;
        };
    }

    public static Specification<Usuario> porFiltros(UsuarioFilter filter) {
        return porNome(filter.getNome()).
                and(nascidoAposAno(filter.getDataNascimento())).
                and(statusDiferenteDe(filter.getStatus()));
    }
}