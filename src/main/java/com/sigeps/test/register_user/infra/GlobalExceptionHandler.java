package com.sigeps.test.register_user.infra;

import com.sigeps.test.register_user.exception.ConflitoDadosException;
import com.sigeps.test.register_user.exception.UsuarioNaoEncontrado;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(UsuarioNaoEncontrado.class)
        private ResponseEntity<String> usuarioNaoEncontradoHandler (UsuarioNaoEncontrado exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found.");
        }

        ExceptionHandler(ConflitoDadosException.class)
            private ResponseEntity<String>  conflitoDeDadosHandler(ConflitoDadosException exception){
            
            }


}
