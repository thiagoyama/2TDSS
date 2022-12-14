package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

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
		System.out.println("Listar clientes com pagina????o");
		clienteDao.listar(0, 2).forEach(c -> System.out.println(c.getNome()));
		
		//Buscar pacotes por pre??o menor, obtendo uma lista de vetor de objetos
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(5000);
		System.out.println("Buscar pacotes por pre??o menor, obtendo uma lista de vetor de objetos");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));
		
		//Buscar pacotes por pre??o menor, retornando uma lista de pacotes com somente a descri????o e a qtdDias preenchidos
		pacotes = pacoteDao.buscarPorPrecoMenor2(10000);
		System.out.println("Buscar pacotes por pre??o menor, retornando uma lista de pacotes");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getDataSaida()));
		
		//Buscar pacotes por pre??o menor, retornando a descri????o em uma lista de string
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(5000);
		System.out.println("Buscar pacote por pre??o menor, retornando uma lista de string");
		listaString.forEach(s -> System.out.println(s));
		
		//Buscar pacotes por data de sa??da
		Calendar inicio = new GregorianCalendar(2020, Calendar.JANUARY, 23);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 30);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Buscar pacotes por data de sa??da");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Buscar clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Salvador");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Buscar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("BA");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Buscar clientes por nome, sem case sensitive
		clientes = clienteDao.buscarPorNome2("A");
		System.out.println("Buscar clientes por parte do nome, sem case sensitive");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Contar os clientes por estado
		long qtdClientes = clienteDao.contarPorEstado("SP");
		System.out.println("Quantidade de clientes por estado: " + qtdClientes);
		
		//Somar pre??os dos pacotes por um transporte
		transporte = transporteDao.pesquisar(2);
		double valor = pacoteDao.somarPrecoPorTransporte(transporte);
		System.out.println("A soma dos pre??os dos pacotes: " + valor);
		
		//Buscar reserva por parte do nome do cliente
		//Instanciar uma ReservaDAO
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Pesquisar as reservas
		List<Reserva> reservas = reservaDao.buscarPorNomeCliente("o");
		System.out.println("Buscar reserva por parte do nome do cliente");
		//Exibir o nome do cliente e a data da reserva
		reservas.forEach(r -> System.out.println(r.getCliente().getNome() + " " 
		                                               + DataUtil.formatar(r.getDataReserva())));
		
		//Buscar reserva por n??mero de dias
		reservas = reservaDao.buscarPorNumeroDias(10);
		System.out.println("Buscar reserva por n??mero de dias");
		reservas.forEach(r -> System.out.println(r.getNumeroDias() + " " + r.getCliente().getNome()));
		
		//Buscar pacotes por qtd de dias maior e pre??o menor
		pacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(5, 5000);
		System.out.println("Buscar pacotes por qtd de dias maior e pre??o menor");
		pacotes.forEach(p -> System.out.println(p.getQtdDias() + " " + p.getPreco() + " " + p.getDescricao()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}//main
	
}//classe






