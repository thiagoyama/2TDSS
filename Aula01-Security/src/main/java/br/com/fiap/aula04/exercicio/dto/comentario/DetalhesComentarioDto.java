package br.com.fiap.aula04.exercicio.dto.comentario;

import br.com.fiap.aula04.exercicio.dto.post.DetalhesPostDto;
import br.com.fiap.aula04.exercicio.model.blog.Comentario;

import java.time.LocalDateTime;

public record DetalhesComentarioDto(Long id, String conteudo, String autor,
                                    LocalDateTime dataCriacao, DetalhesPostDto detalhesPost) {

    public DetalhesComentarioDto(Comentario comentario){
        this(comentario.getId(), comentario.getConteudo(), comentario.getAutor(),
                comentario.getDataCriacao(), new DetalhesPostDto(comentario.getPost()));
    }

}
