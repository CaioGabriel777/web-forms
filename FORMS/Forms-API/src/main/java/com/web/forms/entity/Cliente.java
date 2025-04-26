package com.web.forms.entity;

import jakarta.persistence.*;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_Id")
    private Long id;

    @Column(name = "cl_Nome")
    private String nome;

    @Column(name = "cl_Estado_Civil")
    private String estadoCivil;

    @Column(name = "cl_CPF")
    private String cpf;

    @Column(name = "cl_RG")
    private String rg;

    //@Column(name = "cl_Orgao_Expedidor")
    //private String orgaoExpedidor;

    @Column(name = "cl_Email")
    private String email;

    @Column(name = "cl_CEP")
    private String cep;

    @Column(name = "cl_Modelo_Site")
    private String modelo;




    /**GETTERS E SETTERS**/

    /*public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoexpedidor) {
        this.orgaoExpedidor = orgaoexpedidor;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstadoCivil(){
        return estadoCivil;
    }
    public void setEstadoCivil(String estadocivil){
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
