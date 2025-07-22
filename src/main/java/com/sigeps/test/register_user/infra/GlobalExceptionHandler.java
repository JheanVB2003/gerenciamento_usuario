package com.sigeps.test.register_user.infra;

import com.sigeps.test.register_user.exception.CpfExistenteException;
import com.sigeps.test.register_user.exception.EmailExistenteException;
import com.sigeps.test.register_user.exception.UsuarioNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



        @ExceptionHandler (Exception.class)
        public ResponseEntity<ApiError> erroGenerico (Exception exception){
            ApiError apiError = ApiError
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                    .errors(List.of(exception.getMessage()))
                    .build();

            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        @ExceptionHandler(UsuarioNaoEncontrado.class)
        private ResponseEntity<ApiError> usuarioNaoEncontradoHandler (UsuarioNaoEncontrado exception){
            ApiError apiError = ApiError
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .code(HttpStatus.NOT_FOUND.value())
                    .status(HttpStatus.NOT_FOUND.name())
                    .errors(List.of(exception.getMessage()))
                    .build();
            return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EmailExistenteException.class)
        public ResponseEntity<ApiError> emailExisTente (EmailExistenteException emailExistenteException){
            ApiError apiError = ApiError
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .code(HttpStatus.CONFLICT.value())
                    .status(HttpStatus.CONFLICT.name())
                    .errors(List.of(emailExistenteException.getMessage()))
                    .build();
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
        }

        @ExceptionHandler (CpfExistenteException.class)
        public ResponseEntity<ApiError> cpfExistente (CpfExistenteException cpfExistenteException){
            ApiError apiError = ApiError
                    .builder()
                    .timestamp(LocalDateTime.now())
                    .code(HttpStatus.CONFLICT.value())
                    .status(HttpStatus.CONFLICT.name())
                    .errors(List.of(cpfExistenteException.getMessage()))
                    .build();
            return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
        }




}
