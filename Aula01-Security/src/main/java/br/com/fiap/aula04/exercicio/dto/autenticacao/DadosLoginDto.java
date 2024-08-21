package br.com.fiap.aula04.exercicio.dto.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record DadosLoginDto(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
