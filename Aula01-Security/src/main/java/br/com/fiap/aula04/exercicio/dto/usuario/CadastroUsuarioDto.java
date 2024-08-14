package br.com.fiap.aula04.exercicio.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDto(
        @NotBlank
        @Size(max = 15)
        String username,

        @NotBlank
        String password) {
}
