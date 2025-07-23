package com.sigeps.test.register_user.exception;

public class CpfInvalido extends RuntimeException {

    public CpfInvalido(){
        super  ("CPF inválido!");
    }
    public CpfInvalido(String message) {
        super(message);
    }
}
