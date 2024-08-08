package br.com.fiap.aula04.exercicio.dto.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroTagDto(@NotBlank @Size(max = 20)String nome) {
}
