package com.pieropan.github.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repositorio {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("language")
    private String linguagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "nome='" + nome + '\'' +
                ", linguagem='" + linguagem + '\'' +
                '}';
    }
}