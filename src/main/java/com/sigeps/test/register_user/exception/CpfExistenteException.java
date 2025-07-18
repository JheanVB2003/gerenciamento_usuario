package com.sigeps.test.register_user.exception;

public class CpfExistenteException extends RuntimeException {

    public CpfExistenteException(){
        super("Este CPF já está cadastrado no sistema!");
    }
    public CpfExistenteException(String message) {
        super(message);
    }

}
