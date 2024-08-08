package br.com.fiap.aula04.exercicio.model.blog;

import br.com.fiap.aula04.exercicio.dto.post.CadastroPostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_DETALHES_POST")
@EntityListeners(AuditingEntityListener.class)
public class DetalhesPost {

    @Id
    @GeneratedValue
    @Column(name="cd_detalhes_post")
    private Long id;

    @Column(name="nm_autor", nullable = false, length = 50)
    private String autor;

    @CreatedDate
    @Column(name="dt_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name="dt_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;

    @OneToOne
    @JoinColumn(name="cd_post", nullable = false, unique = true)
    private Post post;

    public DetalhesPost(CadastroPostDto dto){
        autor = dto.autor();
        dataPublicacao = dto.dataPublicacao();
    }

}
