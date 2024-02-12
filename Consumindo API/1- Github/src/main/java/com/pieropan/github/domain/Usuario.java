package com.pieropan.github.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {

    private String login;

    private Long id;

    @JsonProperty("avatar_url")
    private String urlAvatar;

    @JsonProperty("location")
    private String localizacao;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", urlAvatar='" + urlAvatar + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}