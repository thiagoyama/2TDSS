package br.com.fiap.aula04.exercicio.dto.post;

import br.com.fiap.aula04.exercicio.dto.tag.DetalhesTagDto;
import br.com.fiap.aula04.exercicio.model.blog.Post;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhesPostDto(Long codigo, String titulo, String conteudo,
                              String autor, LocalDateTime dataCriacao, LocalDateTime dataPublicacao,
                              List<DetalhesTagDto> tags) {

    public DetalhesPostDto(Post post){
        this(post.getId(), post.getTitulo(), post.getConteudo(), post.getDetalhes().getAutor(),
                post.getDetalhes().getDataCriacao(), post.getDetalhes().getDataPublicacao(),
                post.getTags().stream().map(DetalhesTagDto::new).toList());
    }

}
