package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public final class ContaPoupanca extends Conta implements ContaInvestimento {
	
	private float taxa;
	
	// final: 
	// variável -> não permite alterar o valor
	// métodos -> não permite a sobrescrita
	// classe -> não permite herança
	// static: O elemento pertence a classe e não a instancia (objeto)
	public static final float RENDIMENTO = 0.04f;

	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//Validar se é possível realizar o saque
		if (saldo - (valor + taxa) < 0 ) {
			throw new SaldoInsuficienteException(saldo, taxa);
		} 
		saldo -= valor + taxa;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}
	
	//CTRL + 3 -> gcuf
	
	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
