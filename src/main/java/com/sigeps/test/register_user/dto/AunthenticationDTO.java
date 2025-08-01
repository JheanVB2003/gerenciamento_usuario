package com.sigeps.test.register_user.dto;

import jakarta.validation.constraints.NotBlank;

public record AunthenticationDTO (@NotBlank String email, @NotBlank String senha){
}
