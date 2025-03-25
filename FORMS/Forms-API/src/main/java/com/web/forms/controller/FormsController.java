package com.web.forms.controller;

import com.web.forms.model.Cliente;
import com.web.forms.repository.ClienteRepository;
import com.web.forms.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
public class FormsController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClientesService clientesService;

    @PostMapping("/api/cliente")
    public String adicionar(
            @RequestParam String name,
            @RequestParam String estadocivil,
            @RequestParam String cpf,
            @RequestParam String rg,
            @RequestParam String orgaoexpedidor,
            @RequestParam String email,
            @RequestParam String cep,
            @RequestParam String modelo){

        Cliente cliente = clientesService.salvar(name, estadocivil, cpf, rg, orgaoexpedidor, email, cep, modelo);

        return "redirect:http://localhost:5500/thanks.html";

    }
}
