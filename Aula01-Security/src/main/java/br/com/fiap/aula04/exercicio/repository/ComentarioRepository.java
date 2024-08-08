package br.com.fiap.aula04.exercicio.repository;

import br.com.fiap.aula04.exercicio.model.blog.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
