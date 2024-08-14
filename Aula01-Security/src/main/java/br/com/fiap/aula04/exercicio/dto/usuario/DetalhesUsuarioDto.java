package br.com.fiap.aula04.exercicio.dto.usuario;

import br.com.fiap.aula04.exercicio.model.user.Usuario;

public record DetalhesUsuarioDto(Long id, String username) {

    public DetalhesUsuarioDto(Usuario usuario) {
        this(usuario.getId(),usuario.getUsername());
    }

}
