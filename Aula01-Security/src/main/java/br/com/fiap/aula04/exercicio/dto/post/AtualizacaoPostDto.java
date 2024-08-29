package br.com.fiap.aula04.exercicio.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para atualização de um Post")
public record AtualizacaoPostDto(@Size(max = 50)
                                 @Schema(description = "Título do Post", type = "String", maximum = "50")
                                 String titulo,
                                 @Size(max = 50)
                                 @Schema(description = "Nome do autor do Post", type = "String", maximum = "50")
                                 String autor) {
}
