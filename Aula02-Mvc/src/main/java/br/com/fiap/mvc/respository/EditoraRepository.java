package br.com.fiap.mvc.respository;

import br.com.fiap.mvc.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
