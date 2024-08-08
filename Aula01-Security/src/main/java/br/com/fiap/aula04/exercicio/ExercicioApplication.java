package br.com.fiap.aula04.exercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApplication.class, args);
	}

}
