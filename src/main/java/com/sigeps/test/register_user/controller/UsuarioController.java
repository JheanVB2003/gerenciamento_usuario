package com.sigeps.test.register_user.controller;

import com.sigeps.test.register_user.dto.AunthenticationDTO;
import com.sigeps.test.register_user.dto.LoginResponseDTO;
import com.sigeps.test.register_user.dto.UsuarioDTO;
import com.sigeps.test.register_user.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AunthenticationDTO data){
        LoginResponseDTO token = usuarioService.login(data);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){

            UsuarioDTO novoUsuario = usuarioService.cadastrarUsuario(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);

    }

    @GetMapping({"","/"})
    // @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')") // Admin ou SuperAdmin podem listar
    public ResponseEntity<List<UsuarioDTO>> listarAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioByID(@PathVariable Long id){
       UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioByCpf(@PathVariable String cpf){
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuarioById(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioService.atualizarPessoa(id, usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioById(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }



}
