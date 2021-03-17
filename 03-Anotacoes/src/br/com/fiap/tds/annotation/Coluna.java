package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Teste.java - compilar -> Teste.class (bytecode) -> Interpretar JVM "Executar"

//Definir o lugar em que a anotação pode ser utilizada
//FIELD -> atributos
@Target( { ElementType.FIELD, ElementType.METHOD })

//Definir até quando a anotação estará presente
// SOURCE -> até o código (.java)
// CLASS -> até o bytecode (.class) (default)
// RUNTIME -> até a execução
@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {
	String nome();
	String tipo();
	boolean pk() default false;
	int tamanho() default 255;
}