package com.sigeps.test.register_user.exception;

public class ConflitoDadosException extends RuntimeException {
    public ConflitoDadosException(String message) {
        super(message);
    }

    public ConflitoDadosException(String message, Throwable cause) {
        super(message, cause);
    }
}
