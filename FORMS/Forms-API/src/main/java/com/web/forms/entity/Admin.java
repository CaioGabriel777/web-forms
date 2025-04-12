package com.web.forms.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "user_Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_Id")
    private Long id;

    @Column(name = "admin_Nome")
    private String nome;

    @Column(name = "admin_Email")
    private String email;

    @Column(name = "admin_Senha")
    private String senha;

    /**GETTERS E SETTERS**/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
