package br.com.fiap.aula04.exercicio.model.blog;

import br.com.fiap.aula04.exercicio.dto.comentario.CadastroComentarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_COMENTARIO")
@EntityListeners(AuditingEntityListener.class)
public class Comentario {

    @Id
    @GeneratedValue
    @Column(name="cd_comentario")
    private Long id;

    @Column(name="ds_conteudo", nullable = false, length = 100)
    private String conteudo;

    @CreatedDate
    @Column(name="dt_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name="nm_autor", length = 50)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "cd_post", nullable = false)
    private Post post;

    public Comentario(CadastroComentarioDto dto, Post post){
        conteudo = dto.conteudo();
        autor = dto.autor();
        this.post = post;
    }

}
