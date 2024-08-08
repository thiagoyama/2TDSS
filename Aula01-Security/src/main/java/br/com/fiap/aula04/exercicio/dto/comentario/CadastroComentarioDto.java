package br.com.fiap.aula04.exercicio.dto.comentario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroComentarioDto(@Size(max = 50)
                                    String autor,
                                    @NotBlank @Size(max = 100)
                                    String conteudo) {
}
