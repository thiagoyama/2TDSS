package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar a CidadeDAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Pesquisar as cidades
		List<Cidade> cidades = cidadeDao.listar();
		
		//Exibir todas as cidades
		System.out.println("Listar as cidades:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar as cidades por ddd
		cidades = cidadeDao.buscarPorDdd(11);
		System.out.println("Buscar cidades por DDD");
		for (Cidade cidade: cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getDdd());
		}
		
		//Instanciar o ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Listar todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar os clientes:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar por parte do nome do cliente
		clientes = clienteDao.buscarPorNome("Ma");
		System.out.println("Buscar por parte do nome:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Instanciar um PacoteDAO e TransporteDAO
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Pesquisar um transporte pelo id
		Transporte transporte = transporteDao.pesquisar(3);
		
		//Pesquisar os pacotes por transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		
		//Exibir os pacotes
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//Pesquisar os clientes por estado
		System.out.println("Buscar clientes por estado");
		clienteDao.buscarPorEstado("BA")
			.forEach(c -> System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getUf()));
		
		//Pesquisar os clientes por dias de reserva
		System.out.println("Buscar clientes por dias de reserva");
		clienteDao.buscarPorDiasReserva(10).forEach(c -> System.out.println(c.getNome()));
		
		//Listar os 2 primeiros clientes
		System.out.println("Listar clientes com paginação");
		clienteDao.listar(0, 2).forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}//main
	
}//classe






