package br.com.fiap.tds.orm;

import br.com.fiap.tds.annotation.Tabela;

public class Orm {

	public String gerarPesquisa(Object obj) {
		//Recuperar a anotação @Tabela
		Tabela anotacao = obj.getClass().getAnnotation(Tabela.class);
		return "SELECT * FROM " + anotacao.nome();
	}
	
}
