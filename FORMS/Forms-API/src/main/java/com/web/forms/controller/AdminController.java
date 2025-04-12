package com.web.forms.controller;

import com.web.forms.entity.Admin;
import com.web.forms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> validacaoLogin(@RequestBody Admin credenciais){

        boolean autenticado = adminService.validar(credenciais.getEmail(), credenciais.getSenha());

        if(autenticado){
            return ResponseEntity.ok("Login Realizado Com Sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");

        }
    }
}
