package com.sigeps.test.register_user.exception;

public class CpfInvalido extends RuntimeException {
  public CpfInvalido(String message) {
    super(message);
  }
}
