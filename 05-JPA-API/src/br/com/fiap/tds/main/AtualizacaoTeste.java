package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.TipoEndereco;

// View - Controller - DAO - Banco

public class AtualizacaoTeste {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um endereço com o código (Estado detached)
		Endereco end = new Endereco(1, "39939393", "Rua Olimpiadas", 110, 
												true, TipoEndereco.COMERCIAL);
		
		//Gerencia o objeto e atualiza no banco após o commit
		Endereco endGerenciado = em.merge(end);
		
		//endGerenciado.setAtivo(false);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
