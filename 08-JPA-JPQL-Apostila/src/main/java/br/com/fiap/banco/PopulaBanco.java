package br.com.fiap.banco;

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
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PopulaBanco {

	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		/**
		 * INICIO da persistencia de 3 cidades 
		 */
		Cidade cidade1 = new Cidade("Londrina", "PR", 14, 350);
		Cidade cidade2 = new Cidade("São Paulo", "SP", 11, 11000);
		Cidade cidade3 = new Cidade("Salvador", "BA", 19, 1080);
		
		CidadeDAO cidadeDAO = new CidadeDAOImpl(em);
		cidadeDAO.cadastrar(cidade1);
		cidadeDAO.cadastrar(cidade2);
		cidadeDAO.cadastrar(cidade3);
		cidadeDAO.salvar();
		/**
		 * FIM da persistencia das 3 cidades 
		 */

		/**
		 * INICIO da persistencia de transporte
		 */
		Transporte transporte1 = new Transporte("GOL");
		Transporte transporte2 = new Transporte("COMETA");
		Transporte transporte3 = new Transporte("MSC Cruzeiros");
		
		TransporteDAO transporteDAO = new TransporteDAOImpl(em);
		transporteDAO.cadastrar(transporte1);
		transporteDAO.cadastrar(transporte2);
		transporteDAO.cadastrar(transporte3);
		transporteDAO.salvar();
		/**
		 * FIM da persistencia de transporte 
		 */
		
		/**
		 * INICIO da persistencia de pacotes de viagens
		 */
		Calendar dtSaida1 = new GregorianCalendar(2020, Calendar.JANUARY, 23);
		Pacote pacote1 = new Pacote("Porto de Galinhas", dtSaida1, 7, 2000f, transporte1);
		
		Calendar dtSaida2 = new GregorianCalendar(2020, Calendar.AUGUST, 20);
		Pacote pacote2 = new Pacote("Natal", dtSaida2, 10, 2300f, transporte1);
		
		Calendar dtSaida3 = new GregorianCalendar(2021, Calendar.AUGUST, 13);
		Pacote pacote3 = new Pacote("Bonito", dtSaida3, 8, 500f, transporte2);
		
		Calendar dtSaida4 = new GregorianCalendar(2021, Calendar.JANUARY, 23);
		Pacote pacote4 = new Pacote("Cancun", dtSaida4, 10, 6000f, transporte3);
		
		//Persiste todos os pacotes
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
		pacoteDAO.cadastrar(pacote1);
		pacoteDAO.cadastrar(pacote2);
		pacoteDAO.cadastrar(pacote3);
		pacoteDAO.cadastrar(pacote4);
		pacoteDAO.salvar();
		/**
		 * FIM da persistencia de pacotes de viagens
		 */
		
		/**
		 * INICIO persistencia de clientes e endere�os
		 */
		Endereco end1 = new Endereco("Rua Lins de Vasconcelos", 12898999, cidade2);
		Calendar dtNasc1 = new GregorianCalendar(1983, Calendar.AUGUST, 19);
		List<Pacote> listPac1 = new ArrayList<>();
		listPac1.add(pacote1);
		listPac1.add(pacote2);
		Cliente cliente1 = new Cliente("Thiago", "98728018736", dtNasc1, end1,  listPac1);
		
		Endereco end2 = new Endereco("Rua Duque de Caxias, 2-90", 17017519, cidade1);
		Calendar dtNasc2 = new GregorianCalendar(1990, Calendar.FEBRUARY, 2);
		List<Pacote> listPac2 = new ArrayList<>();
		listPac2.add(pacote1);
		listPac2.add(pacote4);
		Cliente cliente2 = new Cliente("Leandro", "50293494030", dtNasc2, end2,  listPac2);
		
		Endereco end3 = new Endereco("Rua 23 de janeiro, 900", 12892309, cidade3);
		Calendar dtNasc3 = new GregorianCalendar(1999, Calendar.FEBRUARY, 24);
		List<Pacote> listPac3 = new ArrayList<>();
		listPac3.add(pacote2);
		listPac3.add(pacote3);
		listPac3.add(pacote4);
		Cliente cliente3 = new Cliente("Maria", "99828771111", dtNasc3, end3,  listPac3);
		
		Endereco end4 = new Endereco("Av otavio 322", 12220999, cidade3);
		Calendar dtNasc4 = new GregorianCalendar(2000, Calendar.JANUARY, 19);
		List<Pacote> listPac4 = new ArrayList<>();
		listPac4.add(pacote1);
		Cliente cliente4 = new Cliente("Paulo", "90028383848", dtNasc4, end4, listPac4);
		
		Endereco end5 = new Endereco("Rua Lins de Vasconcelos", 12890000, cidade1);
		Calendar dtNasc5 = new GregorianCalendar(1983, Calendar.AUGUST, 19);
		List<Pacote> listPac5 = new ArrayList<>();
		listPac5.add(pacote1);
		listPac5.add(pacote2);
		listPac5.add(pacote3);
		listPac5.add(pacote4);
		Cliente cliente5 = new Cliente("Julio", "88892992922", dtNasc5, end5,  listPac5);
		
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		clienteDAO.cadastrar(cliente1);
		clienteDAO.cadastrar(cliente2);
		clienteDAO.cadastrar(cliente3);
		clienteDAO.cadastrar(cliente4);
		clienteDAO.cadastrar(cliente5);
		clienteDAO.salvar();
		
		/**
		 * FIM persistencia de clientes
		 */
		
		/**
		 * INICIO Persistencia de reservas
		 */
		Calendar dtReseva1 = new GregorianCalendar(2021, Calendar.OCTOBER, 10);
		Reserva reserva1 = new Reserva(10,dtReseva1,pacote1,cliente2);
		
		Calendar dtReseva2 = new GregorianCalendar(2021, Calendar.NOVEMBER, 3);
		Reserva reserva2 = new Reserva(10,dtReseva2,pacote4,cliente5);
		
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		reservaDao.cadastrar(reserva1);
		reservaDao.cadastrar(reserva2);
		reservaDao.salvar();
		/**
		 * FIM Persistencia de reservas
		 */
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
