package br.com.fiap.tds.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.tds.bean.Funcionario;

public class TesteColecao {

	public static void main(String[] args) {
		//Criar uma lista de funcionário
		List<Funcionario> lista = new ArrayList<>();
		
		//Adicionar dois funcionários na lista
		lista.add(new Funcionario("Cleiton", 20));
		
		Funcionario func = new Funcionario("Lucas", 20);
		lista.add(func);
		
		//Exibir os funcionários da lista
		for (int i = 0; i < lista.size(); i ++) {
			System.out.println(lista.get(i).getNome()
								+ " " + lista.get(i).getIdade());
		}
		
		//Foreach
		for (Funcionario f : lista) {
			System.out.println(f);
			//System.out.println(f.getNome() + " " + f.getIdade());
		}
		
		//Mapa
		Map<String, Funcionario> mapa = new HashMap<String,Funcionario>();
				
		//Adicionar dois funcionários no mapa
		mapa.put("f1", new Funcionario("Vinicius", 19));
		mapa.put("f2", new Funcionario("Gabriel", 21));
		
		//Recuperar o funcionário através da chave
		func = mapa.get("f2");
		System.out.println(func.getNome() + " " + func.getIdade());
		
	}//main
	
}//classe