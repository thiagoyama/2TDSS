package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer> {
	
	//3 - Buscar por transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	//Buscar por preço menor, retornando a descrição e a qtd de dias (List<Object[]>)
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	//Buscar por preço menor, retornando a descrição e a qtd de dias (List<Pacote>)
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	//Buscar por preço menor, retornando a descrição (List<String>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	//1 - Buscar por data de saída
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
}
