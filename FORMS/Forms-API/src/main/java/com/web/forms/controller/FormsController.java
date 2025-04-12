package com.web.forms.controller;

import com.web.forms.entity.Cliente;
import com.web.forms.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            Cliente cliente = clientesService.salvar(dados.getNome(), dados.getEstadoCivil(), dados.getCpf(), dados.getRg(), dados.getOrgaoExpedidor(),
                    dados.getEmail(), dados.getCep(), dados.getModelo());
            return ResponseEntity.status(HttpStatus.CREATED).body("Dados Enviados com Sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar os dados.");
        }

    }
}
