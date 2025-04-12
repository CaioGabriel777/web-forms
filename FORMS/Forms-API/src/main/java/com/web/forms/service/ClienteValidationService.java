package com.web.forms.service;

import com.web.forms.exception.MensagemException;
import com.web.forms.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteValidationService {

    public void validarFormulario(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new MensagemException("O campo 'Nome' é obrigatório. ");
        }

        if (cliente.getRg() == null || cliente.getRg().trim().isEmpty()) {
            throw new MensagemException("O campo 'RG' é obrigatório");
        }

        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new MensagemException("O campo 'Email' é obrigatório");
        }

        if (cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
            throw new MensagemException("O campo 'CPF' é obrigatório");
        }

        if (cliente.getCep() == null || cliente.getCep().trim().isEmpty()) {
            throw new MensagemException("O campo 'CEP' é obrigatório");

        }
    }
}
