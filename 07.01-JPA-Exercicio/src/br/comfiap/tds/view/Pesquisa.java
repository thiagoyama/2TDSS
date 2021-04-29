package br.comfiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;
import br.comfiap.tds.entity.CasoTeste;
import br.comfiap.tds.entity.ItemTeste;
import br.comfiap.tds.entity.Sistema;
import br.comfiap.tds.entity.Usuario;

public class Pesquisa {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema
			Sistema sistema = dao.search(1);
			
			//Exibir o nome do sistema
			System.out.println("Sistema: " + sistema.getNome());
			
			//Exibir os casos de teste do sistema
			for (CasoTeste caso : sistema.getCasosTeste()) {
				System.out.println("\nCaso teste: " + caso.getNome() + " " + caso.getDescricao());
				
				//Exibir os itens de teste dos casos de teste
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println("\nItem teste: " + item.getDescricao());
					
					System.out.print("\nUsuários: ");
					//Exibir os usuários dos itens de teste
					for (Usuario usuario : item.getUsuarios()) {
						System.out.print(usuario.getNome() + " ");
					}
				}
			}
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe
