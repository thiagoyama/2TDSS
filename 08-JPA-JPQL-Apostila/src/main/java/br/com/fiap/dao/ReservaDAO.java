package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	//Buscar por parte do nome do cliente
	List<Reserva> buscarPorNomeCliente(String nome);
	
	//Buscar por numero dias igual
	List<Reserva> buscarPorNumeroDias(int numero);
	
}
