package com.sigeps.test.register_user.infra;

import com.sigeps.test.register_user.exception.UsuarioNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(UsuarioNaoEncontrado.class)
        private ResponseEntity<String> usuarioNaoEncontradoHandler (UsuarioNaoEncontrado exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found.");
        }
}
