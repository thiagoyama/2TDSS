package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoChallengeDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.GrupoChallenge;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//1 - Cadastrar um aluno com um grupo que já existe no banco
		
		//Obter um GrupoDao e AlunoDao
		GrupoChallengeDao grupoDao = new GrupoChallengeDaoImpl(em);
		GenericDao<Aluno,Integer> alunoDao = new GenericDaoImpl<Aluno,Integer>(em){};
		
		try {
			//Pesquisar o grupo
			GrupoChallenge grupo = grupoDao.search(1);
			
			//Instanciar um aluno com o grupo
			Aluno aluno = new Aluno("Marcus", new GregorianCalendar(2000, Calendar.APRIL, 1), "Scrum Master");
			aluno.setGrupo(grupo);
			
			//Cadastrar o aluno
			alunoDao.create(aluno);
			alunoDao.commit();
			System.out.println("Aluno registrado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//2 - Associar um aluno à um curso que já existem no banco
		
		//Obter um CursoDao
		GenericDao<NanoCourse,Integer> nanoDao = new GenericDaoImpl<NanoCourse,Integer>(em) {};
		
		try {
			//Pesquisar um curso
			NanoCourse nano = nanoDao.search(1);
			//Pesquisar um aluno
			Aluno aluno = alunoDao.search(4);
			
			//Setar o curso na lista de cursos do aluno
			aluno.getCursos().add(nano);
			
			//Atualizar o aluno
			alunoDao.update(aluno);
			alunoDao.commit();
			System.out.println("Aluno matriculado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println("Deu ruim..");
		}
		
	}//main
	
}//classe