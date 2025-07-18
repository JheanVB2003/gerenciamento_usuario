package com.sigeps.test.register_user.exception;

public class EmailExistenteException extends RuntimeException {
  public EmailExistenteException(String message) {
    super(message);
  }
}
