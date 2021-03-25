package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		//Obter um objeto que gerencia as entidades EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
