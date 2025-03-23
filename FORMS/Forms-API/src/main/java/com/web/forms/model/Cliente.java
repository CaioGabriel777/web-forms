package com.web.forms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String estadocivil;

    private String cpf;

    private String rg;

    private String orgaoexpedidor;

    private String email;

    private String cep;

    private String modelo;



    //GETTERS E SETTERS

    public String getOrgaoexpedidor() {
        return orgaoexpedidor;
    }

    public void setOrgaoexpedidor(String orgaoexpedidor) {
        this.orgaoexpedidor = orgaoexpedidor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEstadocivil(){
        return estadocivil;
    }
    public void setEstadocivil(String estadocivil){
        this.estadocivil = estadocivil;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getRg(){
        return rg;
    }
    public void setRg(String rg){
        this.rg = rg;
    }

}
