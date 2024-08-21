package br.com.fiap.aula04.exercicio.service;

import br.com.fiap.aula04.exercicio.model.user.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}") //Valor configurado no application.properties
    private String senha;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(senha);
            return JWT.create()
                    .withIssuer("FIAP")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao criar o token JWT");
        }
    }

}
