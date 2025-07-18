package com.sigeps.test.register_user.dto;

import com.sigeps.test.register_user.model.Sexo;
import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDTO {


    private String nome;

    @CPF
    private String cpf;
    private String email;
    private Sexo sexo;
    private String telefone;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nome, String cpf, String email, Sexo sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
