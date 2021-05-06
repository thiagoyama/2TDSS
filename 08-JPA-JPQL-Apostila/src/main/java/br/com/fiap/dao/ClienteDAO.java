package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {

	//2 - Pesquisar por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//4 - Pesquisar por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//5 - Pesquisar por número de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);
	
}
