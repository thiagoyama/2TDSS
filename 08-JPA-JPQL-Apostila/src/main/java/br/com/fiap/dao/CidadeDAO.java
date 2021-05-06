package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer> {
	
	//Listar todas as cidades
	List<Cidade> listar();
	
	//Buscar por ddd
	List<Cidade> buscarPorDdd(int ddd);

}
