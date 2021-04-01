package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.EnderecoDao;
import br.com.fiap.tds.dao.impl.EnderecoDaoImpl;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.TipoEndereco;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EnderecoNotFoundException;

public class EnderecoDaoTeste {

	public static void main(String[] args) {
		
		//Obter o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um enderecoDao
		EnderecoDao dao = new EnderecoDaoImpl(em);
		
		//Cadastrar um endereço
		Endereco end = new Endereco("123423", "Av Paulista", 1222, true, TipoEndereco.AP);
		
		try {
			dao.create(end);
			dao.commit();
			System.out.println("Endereço registrado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um endereço e exibir os dados
		try {
			end = dao.search(23);
			System.out.println(end);
		} catch (EnderecoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar um endereço
		end = new Endereco(23, "29380212", "Rua Duque de Caxias", 10, false, TipoEndereco.CASA);
		
		try {
			dao.update(end);
			dao.commit();
			System.out.println("Endereço atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um endereço
		try {
			dao.delete(23);
			dao.commit();
			System.out.println("Endereço removido");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (EnderecoNotFoundException e) {
			System.out.println("Endereço não existe para ser removido");
		}
		
		//Fechar
		em.close();
		fabrica.close();

	}//main
	
}//classe