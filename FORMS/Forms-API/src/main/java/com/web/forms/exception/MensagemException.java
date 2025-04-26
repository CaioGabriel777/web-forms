package com.web.forms.exception;

public class MensagemException extends RuntimeException{

    private String mensagem;

    public MensagemException(String pMensagem){
        super(pMensagem);
    }

}
