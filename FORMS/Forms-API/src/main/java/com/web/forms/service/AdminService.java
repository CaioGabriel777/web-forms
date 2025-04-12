package com.web.forms.service;

import com.web.forms.entity.Admin;
import com.web.forms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean validar(String email, String senha){

        Admin admin = adminRepository.findByEmail(email);

        if(admin != null && admin.getSenha().equals(senha)){
            return true;
        }
        return false;
    }

}
