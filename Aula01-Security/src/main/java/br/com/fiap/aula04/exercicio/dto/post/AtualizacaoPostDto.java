package br.com.fiap.aula04.exercicio.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoPostDto(@Size(max = 50)
                                 String titulo,
                                 @Size(max = 50)
                                 String autor) {
}
