package br.com.fiap.aula04.exercicio.dto.tag;

import br.com.fiap.aula04.exercicio.model.Tag;

public record DetalhesTagDto(Long id, String nome) {
    public DetalhesTagDto(Tag tag) {
        this(tag.getId(), tag.getNome());
    }
}
