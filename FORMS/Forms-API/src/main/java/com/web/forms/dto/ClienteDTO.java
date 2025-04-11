package com.web.forms.dto;

public class ClienteDTO {

    private String nome;

    private String estadoCivil;

    private String cpf;

    private String rg;

    private String orgaoExpedidor;

    private String email;

    private String cep;

    private String modelo;



    /**GETTERS E SETTERS**/

    public String getOrgaoexpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoexpedidor(String orgaoexpedidor) {
        this.orgaoExpedidor = orgaoexpedidor;
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

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEstadocivil(){
        return estadoCivil;
    }

    public void setEstadocivil(String estadocivil){
        this.estadoCivil = estadocivil;
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
