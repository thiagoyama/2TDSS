package br.com.fiap.aula04.exercicio.repository;

import br.com.fiap.aula04.exercicio.model.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
