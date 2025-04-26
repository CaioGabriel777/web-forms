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
    public Cliente salvar(String pNome, String pEstadoCivil, String pCpf, String pRg, /*String pOrgaoExpedidor,*/ String pEmail,
                          String pCep, String pModelo){

        Cliente cliente = new Cliente();
        for(char c : pNome.toCharArray()){
            if(Character.isDigit(c)){
                throw new RuntimeException("Nome não pode ter números");
            }
        }
        cliente.setNome(pNome);
        cliente.setEstadoCivil(pEstadoCivil);
        cliente.setCpf(pCpf);
        cliente.setRg(pRg);
        //cliente.setOrgaoExpedidor(pOrgaoExpedidor);
        cliente.setEmail(pEmail);
        cliente.setCep(pCep);
        cliente.setModelo(pModelo);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarPorNome(String pNome){
        return clienteRepository.findByNomeContainingIgnoreCase(pNome);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public void deletar(Long pId){
        clienteRepository.deleteById(pId);
    }
}
