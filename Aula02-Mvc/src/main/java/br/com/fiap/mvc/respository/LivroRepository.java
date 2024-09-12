package br.com.fiap.mvc.respository;

import br.com.fiap.mvc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
