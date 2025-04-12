package com.web.forms.dto;

import jakarta.persistence.Column;

public class AdminDTO {

    private String nome;

    @Column(name = "admin_Email")
    private String email;

    @Column(name = "admin_Senha")
    private String senha;

    /**GETTERS E SETTERS**/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
