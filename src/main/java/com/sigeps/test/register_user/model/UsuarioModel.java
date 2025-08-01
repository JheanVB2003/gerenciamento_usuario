package com.sigeps.test.register_user.model;

import com.sigeps.test.register_user.enums.Perfil;
import com.sigeps.test.register_user.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "O NOME é obrigatório")
    @Column(nullable = false)
    private String nome;

    @CPF(message = "CPF inválido!")
    @NotBlank(message = "O CPF é obrigatório")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Email(message = "EMAIL inválido!")
    @NotBlank(message = "O EMAIL é obrigatório")
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotBlank(message = "O TELEFONE é obrigatório")
    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Boolean ativo;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public UsuarioModel(String nome, String cpf, String email, Sexo sexo, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.senha = senha;
        this.perfil = Perfil.ROLE_ADMIN;
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
    }

    public void alterarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void alterarSenha(String senha){
        this.senha = senha;
    }

    public void ativarUsuario(){
        this.ativo = true;
    }

    public void inativarUsuario(){
        this.ativo = false;
    }

    public void atualizarDados(String nome, String cpf, String email, Sexo sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataAtualizacao = LocalDateTime.now();
    }
}
