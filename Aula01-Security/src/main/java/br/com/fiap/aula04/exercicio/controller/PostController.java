package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.comentario.CadastroComentarioDto;
import br.com.fiap.aula04.exercicio.dto.comentario.DetalhesComentarioDto;
import br.com.fiap.aula04.exercicio.dto.post.AtualizacaoPostDto;
import br.com.fiap.aula04.exercicio.dto.post.CadastroPostDto;
import br.com.fiap.aula04.exercicio.dto.post.DetalhesPostDto;
import br.com.fiap.aula04.exercicio.model.blog.Comentario;
import br.com.fiap.aula04.exercicio.model.blog.Post;
import br.com.fiap.aula04.exercicio.repository.ComentarioRepository;
import br.com.fiap.aula04.exercicio.repository.PostRepository;
import br.com.fiap.aula04.exercicio.repository.TagRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("posts")
@Tag(name = "Post", description = "Realiza ações de CRUD do Post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TagRepository tagRepository;

    @DeleteMapping("{idPost}/tags")
    @Transactional
    @Operation(summary = "Remove todas as Tag de um Post", description = "Remove todas as Tag associadas a um Post")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tags removidas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id do post não encontrado"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    @Parameter(name = "idPost", description = "Id do post que terá as tags removidas", required = true)
    public ResponseEntity<Void> deleteTags(@PathVariable("idPost") Long idPost){
        var post = postRepository.getReferenceById(idPost);
        post.getTags().clear();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idPost}/tags/{idTag}")
    @Transactional
    @Operation(summary = "Remove uma Tag de um Post", description = "Remove uma Tag associada a um Post")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tag removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id do post ou da tag não encontrada"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    @Parameters({
            @Parameter(name = "idPost", description = "Id do post que terá a tag removida"),
            @Parameter(name = "idTag", description = "Id da tag que será removida do post")
    })
    public ResponseEntity<Void> delete(@PathVariable("idPost") Long idPost,
                                       @PathVariable("idTag") Long idTag) {
        var post = postRepository.getReferenceById(idPost);
        var tag = tagRepository.getReferenceById(idTag);
        post.getTags().remove(tag);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idPost}/tags/{idTag}")
    @Transactional
    public ResponseEntity<DetalhesPostDto> put(@PathVariable("idPost") Long idPost,
                                               @PathVariable("idTag") Long idTag) {
        var post = postRepository.getReferenceById(idPost);
        var tag = tagRepository.getReferenceById(idTag);
        post.getTags().add(tag); //Acessa a lista de tags do post e adiciona a nova tag
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @PostMapping("{id}/comentarios")
    @Transactional
    public ResponseEntity<DetalhesComentarioDto> post(@PathVariable("id") Long id,
                                                      @RequestBody @Valid CadastroComentarioDto dto,
                                                      UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var post = postRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var comentario = new Comentario(dto, post);
        comentarioRepository.save(comentario);
        var uri = uriBuilder.path("comentarios/{id}").buildAndExpand(comentario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesComentarioDto(comentario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPostDto> create(@RequestBody @Valid CadastroPostDto dto,
                                                  UriComponentsBuilder uriBuilder) {
        var post = new Post(dto);
        postRepository.save(post);
        var url = uriBuilder.path("/posts/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPostDto(post));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesPostDto>> get(Pageable pageable){
        var lista = postRepository.findAll(pageable).stream().map(DetalhesPostDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPostDto> get(@PathVariable("id") Long id){
        var post = postRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualiza um Post", description = "Atualiza o titulo e/ou autor do post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesPostDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Id do post não encontrado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado",content = @Content)
    })
    public ResponseEntity<DetalhesPostDto> put(@PathVariable("id") Long id, @RequestBody AtualizacaoPostDto dto){
        var post = postRepository.getReferenceById(id);
        post.atualizar(dto);
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Hidden
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
