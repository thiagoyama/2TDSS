package br.com.fiap.tds.bean;

public class Pessoa {

	//Modificadores de acessos:
	// private -> apenas a própria classe; 
	// public -> todos;
	// protected -> todos do pacote e classes filhas;
	// default (package) -> todos do pacote; 
	
	// Tipos primitivos: byte, short, int, long, float, double, char, boolean
	// Valor padrão: números = 0, boolean = false;
	
	// Tipos de referência (Classes): String, Pessoa, Departamento
	// Valor padrão: null;
	
	//Atributos                 
	private String nome;
	
	private int idade;
	
	private boolean deficiente;
	
	//Construtores
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, boolean deficiente) {
		this.nome = nome;
		this.idade = idade;
		this.deficiente = deficiente;
	}
	
	public Pessoa() {}
	
	//Métodos
	public void cadastrar() {
		System.out.println("Cadastrando uma pessoa....");
	}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void cadastrar(String nome) {
		System.out.println("Cadastrando o/a " + nome);
	}
	
	public void cadastrar(String nome, int idade) {
		System.out.println("Cadastrando com nome e idade");
	}
	
	public void setDeficiente(boolean deficiente) {
		this.deficiente = deficiente;
	}
	
	public boolean isDeficiente() {
		return deficiente;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
