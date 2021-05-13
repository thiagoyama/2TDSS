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
	
	//2 - Pesquisar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//3 - Pesquisar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Pesquisar por parte do nome, sem diferenciar maiúsculas e minúsculas, ordenando por nome
	List<Cliente> buscarPorNome2(String nome);
	
	//Contar a quantidade de clientes de um estado 
	long contarPorEstado(String estado);
	
}
