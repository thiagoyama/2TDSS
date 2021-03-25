package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Endereco;

public class RefreshTeste {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o endereço de código 1
		Endereco end = em.find(Endereco.class, 1);
		
		//Exibir os dados
		System.out.println(end);
		
		//Setar os valores do número e logradouro (no objeto)
		end.setNumero(888);
		end.setLogradouro("Duque de caxias");
		
		//Exibir os dados
		System.out.println(end);
		
		//Refresh
		em.refresh(end);
		
		//Exibir os dados
		System.out.println(end);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
