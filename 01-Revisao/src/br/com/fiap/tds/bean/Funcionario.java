package br.com.fiap.tds.bean;

public class Funcionario extends Pessoa {

	//Construtor é herdado? Não
	
	public Funcionario(String nome, int idade) {
		super(nome, idade);
	}
	
	public Funcionario() {}
	
	@Override
	public String toString() {
		return getNome() + " -- " + getIdade();
	}
	
	//Sobrescrita -> mesmo método na classe filha
	@Override
	public void cadastrar() {
		System.out.println("Cadastrando um funcionário...");
	}
	
}