package com.temm.desafiotecnico.usuario.application.api;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UsuarioDTO(
        @NotBlank(message = "Email não pode ser nulo")
        String email,
        @NotBlank(message = "Senha não pode ser nula")
        @Length(min = 8, max = 8, message = "Deve ter 8 caracteres")
        String password) {
}
