package com.sigeps.test.register_user.exception;

public class EmailExistenteException extends RuntimeException {

    public  EmailExistenteException(){
        super("Email já cadastrado no sistema!");
    }
    public EmailExistenteException(String message) {
        super(message);
    }
}
