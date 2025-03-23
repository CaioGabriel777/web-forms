package com.web.forms.controller;

import com.web.forms.model.Cliente;
import com.web.forms.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/cliente")
public class formsController {

    @Autowired
    private clienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionar(@RequestParam String name, @RequestParam String estadocivil,
    @RequestParam String cpf, @RequestParam String rg, @RequestParam String orgaoexpedidor,
                            @RequestParam String email, @RequestParam String cep, @RequestParam String modelo){

        Cliente cliente = new Cliente();
        cliente.setName(name);
        cliente.setEstadocivil(estadocivil);
        cliente.setCpf(cpf);
        cliente.setRg(rg);
        cliente.setOrgaoexpedidor(orgaoexpedidor);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setModelo(modelo);

        clienteRepository.save(cliente);

        return "Dados recebidos com sucesso";

    }
}
