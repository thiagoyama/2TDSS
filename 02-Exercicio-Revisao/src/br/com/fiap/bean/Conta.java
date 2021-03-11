package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//Classe abstrata -> não pode ser instanciada 
//e pode ou não ter métodos abstratos (sem implementação)

public abstract class Conta {
	
	private int agencia;
	
	private int numero;
	
	private Calendar dataAbertura;
	
	protected double saldo;
	
	//CTRL + 3 -> ggas (gets e sets), gcuf (construtor)
	
	public abstract void retirar(double valor) throws SaldoInsuficienteException;
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public Conta() {}
	
	public Conta(int agencia, int numero, Calendar dataAbertura, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}

	//Gets e sets
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}