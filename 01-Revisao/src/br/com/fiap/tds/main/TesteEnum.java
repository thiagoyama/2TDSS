package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bean.Genero;

public class TesteEnum {

	public static void main(String[] args) {
		//Instanciar um funcionario
		Funcionario funcionario = new Funcionario("Gustavo", 19);
		
		//Atribuir um valor para o gênero do funcionário
		funcionario.setGenero(Genero.MASCULINO);
		
		//Validar se o gênero é feminino
		if (funcionario.getGenero() == Genero.FEMININO) {
			System.out.println("É uma colaboradora");
		}
		
		//Exibir o gênero
		System.out.println(funcionario.getGenero());
		
	}//main
	
}//classe
