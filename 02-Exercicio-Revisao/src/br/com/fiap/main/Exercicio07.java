package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		//Criar uma lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas
		lista.add(new ContaCorrente(1, 241, Calendar.getInstance(), 188, TipoConta.COMUM));
		lista.add(new ContaCorrente(1, 223, Calendar.getInstance(), 782, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(1, 523, Calendar.getInstance(), 67, TipoConta.ESPECIAL));
		
		//Exibir o saldo das contas
		for (ContaCorrente churros : lista) {
			System.out.println(churros.getSaldo());
		}
		
		lista.forEach(churros -> System.out.println(churros.getSaldo()));
		
	}
	
}
