package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Categoria;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.ProjetoChallenge;
import br.com.fiap.tds.entity.TipoProjeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

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
		
		//Instanciar 3 alunos e adicionar no grupo
		Aluno aluno1 = new Aluno("Alison", 
				new GregorianCalendar(2000, Calendar.APRIL, 1), "Dev");
		
		Aluno aluno2 = new Aluno("Lucas", 
				new GregorianCalendar(1999, Calendar.OCTOBER, 8), "UX");
		
		Aluno aluno3 = new Aluno("Henrique",
				new GregorianCalendar(2001, Calendar.AUGUST, 20), "Devops");
		
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		
		//Cadastrar os cursos relacionados com alunos
		//Instanciar 2 ou 3 cursos
		NanoCourse nano1 = new NanoCourse("Java", 10, 40, Categoria.PROGRAMACAO);
		NanoCourse nano2 = new NanoCourse("Negociação", 10, 30, Categoria.DESENVOLVIMENTO_PESSOAL);
		NanoCourse nano3 = new NanoCourse("Usabilidade", 5, 25, Categoria.DESIGN);
		
		//Criar uma lista de curso e adicionar os cursos
		List<NanoCourse> cursos = new ArrayList<>();
		cursos.add(nano1);
		cursos.add(nano2);
		cursos.add(nano3);
		
		//Adicionar a lista de curso no aluno
		aluno1.setCursos(cursos);
		aluno2.setCursos(cursos);
		
		//Cadastrar o Projeto
		//projetoDao.create(projeto);
		
		//Cadastrar o Grupo
		grupoDao.create(grupo);
		
		//Commit
		try {
			grupoDao.commit();
			//projetoDao.commit();
			System.out.println("Grupo e Projeto cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}