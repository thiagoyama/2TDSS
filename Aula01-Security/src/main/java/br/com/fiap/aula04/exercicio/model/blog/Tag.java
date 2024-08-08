package br.com.fiap.aula04.exercicio.model.blog;

import br.com.fiap.aula04.exercicio.dto.tag.CadastroTagDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor

@Entity
@Table(name="TB_TAG")
public class Tag {

    @Id
    @Column(name="cd_tag")
    @GeneratedValue
    private Long id;

    @Column(name="nm_tag", nullable = false, length = 20)
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    public Tag(CadastroTagDto dto) {
        this.nome = dto.nome();
    }
}
