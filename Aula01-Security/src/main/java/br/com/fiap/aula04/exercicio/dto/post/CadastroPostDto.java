package br.com.fiap.aula04.exercicio.dto.post;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CadastroPostDto(
        @NotBlank @Size(max = 50)
        String titulo,
        @NotBlank @Size(max = 500)
        String conteudo,
        @NotBlank @Size(max = 50)
        String autor,
        @Future @NotNull
        LocalDateTime dataPublicacao) {
}
