package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.TipoEndereco;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Instanciar um endereço sem o código (Estado : novo - não gerenciado)
		Endereco end = new Endereco("11230934", "Av Lins de vasconcelos", 
											1222, true, TipoEndereco.COMERCIAL);
		
		//Coloca o endereço no contexto do entity manager (gerenciado)
		em.persist(end);
		
		//Iniciar uma transação
		em.getTransaction().begin();
		//Commit
		em.getTransaction().commit();
		
		System.out.println("Endereço registrado!");
		
		end.setNumero(100);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
