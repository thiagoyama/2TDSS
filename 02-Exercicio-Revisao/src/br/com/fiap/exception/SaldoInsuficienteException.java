package br.com.fiap.exception;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception {
	
	public SaldoInsuficienteException() {
		super("Saldo insuficiente");
	}
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
	public SaldoInsuficienteException(double saldo) {
		super("Saldo insuficiente, limite máximo: " + saldo);
	}
	
	public SaldoInsuficienteException(double saldo, float taxa) {
		super("Saldo insuficiente, limite máximo: " + (saldo - taxa) 
				+ ", taxa de retirada: " + taxa);
	}

}