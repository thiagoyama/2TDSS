package br.com.fiap.aula04.exercicio.repository;

import br.com.fiap.aula04.exercicio.model.blog.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
