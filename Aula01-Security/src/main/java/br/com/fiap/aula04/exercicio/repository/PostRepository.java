package br.com.fiap.aula04.exercicio.repository;

import br.com.fiap.aula04.exercicio.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
