package com.web.forms.service;

import com.web.forms.entity.Cliente;
import com.web.forms.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClientesService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente salvar(String nome, String estadoCivil, String cpf, String rg, String orgaoExpedidor, String email,
                          String cep, String modelo){

        Cliente cliente = new Cliente();
        for(char c : nome.toCharArray()){
            if(Character.isDigit(c)){
                throw new RuntimeException("Nome não pode ter números");
            }
        }
        cliente.setNome(nome);
        cliente.setEstadoCivil(estadoCivil);
        cliente.setCpf(cpf);
        cliente.setRg(rg);
        cliente.setOrgaoExpedidor(orgaoExpedidor);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setModelo(modelo);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarPorNome(String nome){
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }
}
