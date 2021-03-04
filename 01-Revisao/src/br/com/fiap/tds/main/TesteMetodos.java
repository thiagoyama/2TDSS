package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.bean.Pessoa;

public class TesteMetodos {

	public static void main(String[] args) {
		
		//Instanciar uma Pessoa
		Pessoa pessoa = new Pessoa();
		
		//Chamar o método cadastrar()
		pessoa.cadastrar(); // Pessoa
		
		//Instanciar um Funcionario
		Funcionario func = new Funcionario();
		
		//Chamar o método cadastrar()
		func.cadastrar(); // Funcionario
		
		Pessoa p = new Funcionario();
		p.cadastrar(); // Funcionario
		
		//Funcionario f = new Pessoa(); //Não compila
		
	}
	
}