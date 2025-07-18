package com.sigeps.test.register_user.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontrado extends RuntimeException {
    public UsuarioNaoEncontrado() {
        super("Usuário não encontrado!");
    }

    public UsuarioNaoEncontrado(String message){
        super(message);
    }
}
