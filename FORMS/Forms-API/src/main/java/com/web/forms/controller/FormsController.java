package com.web.forms.controller;

import com.web.forms.model.Cliente;
import com.web.forms.repository.ClienteRepository;
import com.web.forms.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class FormsController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> cliente = clientesService.buscarTodos();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<Cliente>> buscarPorNome(@PathVariable String nome){
        List<Cliente> cliente = clientesService.buscarPorNome(nome);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> adicionar(@RequestBody Cliente dados){

        try{
            Cliente cliente = clientesService.salvar(dados.getNome(), dados.getEstadocivil(), dados.getCpf(), dados.getRg(), dados.getOrgaoexpedidor(),
                    dados.getEmail(), dados.getCep(), dados.getModelo());
            return ResponseEntity.ok("Dados Salvo com Sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
