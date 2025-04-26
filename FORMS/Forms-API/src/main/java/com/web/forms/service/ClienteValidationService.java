package com.web.forms.service;

import com.web.forms.exception.MensagemException;
import com.web.forms.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteValidationService {

    public void validarFormulario(Cliente pCliente) {

        if (pCliente.getNome() == null || pCliente.getNome().trim().isEmpty()) {
            throw new MensagemException("O campo 'Nome' é obrigatório. ");
        }

        if (pCliente.getRg() == null || pCliente.getRg().trim().isEmpty()) {
            throw new MensagemException("O campo 'RG' é obrigatório");
        }

        if (pCliente.getEmail() == null || pCliente.getEmail().trim().isEmpty()) {
            throw new MensagemException("O campo 'Email' é obrigatório");
        }

        if (pCliente.getCpf() == null || pCliente.getCpf().trim().isEmpty()) {
            throw new MensagemException("O campo 'CPF' é obrigatório");
        }

        if (pCliente.getCep() == null || pCliente.getCep().trim().isEmpty()) {
            throw new MensagemException("O campo 'CEP' é obrigatório");

        }
    }
}
