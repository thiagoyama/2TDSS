package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.tag.CadastroTagDto;
import br.com.fiap.aula04.exercicio.dto.tag.DetalhesTagDto;
import br.com.fiap.aula04.exercicio.model.blog.Tag;
import br.com.fiap.aula04.exercicio.repository.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesTagDto> post(@RequestBody @Valid CadastroTagDto dto, UriComponentsBuilder uriBuilder){
        var tag = new Tag(dto);
        tagRepository.save(tag);
        var uri = uriBuilder.path("tags/{id}").buildAndExpand(tag.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTagDto(tag));
    }

}
