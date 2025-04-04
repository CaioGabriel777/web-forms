package com.web.forms.services;

import com.web.forms.model.Cliente;
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
    public Cliente salvar(String nome, String estadocivil, String cpf, String rg, String orgaoexpedidor, String email,
                          String cep, String modelo){

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEstadocivil(estadocivil);
        cliente.setCpf(cpf);
        cliente.setRg(rg);
        cliente.setOrgaoexpedidor(orgaoexpedidor);
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
