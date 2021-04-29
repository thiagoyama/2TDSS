package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {
	
	public static void main(String[] args) {
		
		//Obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoChallengeDao
		GrupoChallengeDao dao = new GrupoChallengeDaoImpl(em);
		
		try {
			//Pesquisar um grupo
			GrupoChallenge grupo = dao.search(1);
			
			//Exibir o nome do grupo
			System.out.println("Grupo: " + grupo.getNome());
			
			//Exibir o nome do projeto
			System.out.println("Projeto: " + grupo.getProjeto().getNome());
			
			//Exibir o nome dos alunos que pertencem ao grupo
			System.out.println("Alunos:");
			for (Aluno aluno : grupo.getAlunos()) {
				System.out.println(aluno.getNome());
				
				//Exibir o nome dos cursos dos alunos
				System.out.println("Cursos:");
				for (NanoCourse nano : aluno.getCursos()) {
					System.out.println(nano.getNome());
				}
			}
			
		}catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}
