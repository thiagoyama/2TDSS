package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a única instância da EntityManagerFactory 
 *
 */
public class EntityManagerFactorySingleton {

	// 1 - Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	// 2 - Construtor privado -> ninguem consegue instanciar
	private EntityManagerFactorySingleton() {}
	
	// 3 - Método estático que retorna a única instância
	public static EntityManagerFactory getInstance() {
		
		//Validar se existe a fabrica
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		
		return fabrica;
	}
 	
}