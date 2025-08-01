package com.sigeps.test.register_user.dto;

import com.sigeps.test.register_user.enums.Perfil;
import com.sigeps.test.register_user.enums.Sexo;

public record UsuarioDTO (
        String nome,
        String cpf,
        String email,
        Sexo sexo,
        String telefone,
        String senha
){}
