package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.entity.TipoProjeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

	//Cadastrar um projeto e o grupo por cascata
	public static void main(String[] args) {
		//Cadastrar um grupo e um projeto relacionados
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoChallengeDao e ProjetoChallengeDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		ProjetoChallengeDao projetoDao = new ProjetoChallengeDaoImpl(em);
		
		//Instanciar um Projeto
		ProjetoChallenge projeto = new ProjetoChallenge("IOT para mudar vidas",
			"Tecnologia para mudar vida", Calendar.getInstance(), 
			new GregorianCalendar(2021, Calendar.OCTOBER, 10), TipoProjeto.TECNOLOGIA, null);
		
		//Instanciar um Grupo com o projeto
		GrupoChallenge grupo = new GrupoChallenge("Fiapers Dev", projeto);
		
		projeto.setGrupo(grupo);
		
		//Cadastrar o Projeto
		//Sempre que utilizar um atributo com mappedBy para o persist em cascata
		//Precisamos setar o atributo que mapeia a FK no banco (outro lado da relação)
		projetoDao.create(projeto);
		
		//Cadastrar o Grupo
		//grupoDao.create(grupo);
		
		//Commit
		try {
			//grupoDao.commit();
			projetoDao.commit();
			System.out.println("Grupo e Projeto cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}