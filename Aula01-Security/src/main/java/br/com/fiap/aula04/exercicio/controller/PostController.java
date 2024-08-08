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
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TagRepository tagRepository;

    @DeleteMapping("{idPost}/tags")
    @Transactional
    public ResponseEntity<Void> deleteTags(@PathVariable("idPost") Long idPost){
        var post = postRepository.getReferenceById(idPost);
        post.getTags().clear();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idPost}/tags/{idTag}")
    @Transactional
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
    public ResponseEntity<DetalhesPostDto> put(@PathVariable("id") Long id, @RequestBody AtualizacaoPostDto dto){
        var post = postRepository.getReferenceById(id);
        post.atualizar(dto);
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
