package br.com.fiap.tds.main;

public class TesteTernario {

	public static void main(String[] args) {
		int x = 11;
		
		if (x > 10) {
			System.out.println("Maior que 10");
		} else {
			System.out.println("Menor ou igual a 10");
		}
		
		//Ternário
		System.out.println(x>10?"Maior que 10":"Menor ou igual a 10");
		
	}
	
}
