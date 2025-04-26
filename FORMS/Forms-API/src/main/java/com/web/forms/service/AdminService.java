package com.web.forms.service;

import com.web.forms.entity.Admin;
import com.web.forms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean validar(String pEmail, String pSenha){

        Admin admin = adminRepository.findByEmail(pEmail);

        if(admin != null && admin.getSenha().equals(pSenha)){
            return true;
        }
        return false;
    }

}
