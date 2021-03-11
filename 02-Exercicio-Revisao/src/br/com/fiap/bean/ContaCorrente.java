package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//A primeira classe "concreta" deve implementar os métodos abstratos

public class ContaCorrente extends Conta {

	private TipoConta tipo; //CTRL + 1
	
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		// Tipo da conta é comum e o saldo fica negativo dps do saque
		if (tipo == TipoConta.COMUM && saldo - valor < 0) {
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor; //saldo = saldo + valor;
//	}
	
	//CTRL + 3 -> gcuf
	public ContaCorrente() {}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}