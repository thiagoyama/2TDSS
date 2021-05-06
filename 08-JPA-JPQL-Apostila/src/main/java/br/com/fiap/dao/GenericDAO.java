package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws EntityNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws CommitException;
	
	List<T> listar();
	
	//Listar que permite definir a primeira posição que será retornada e o máximo de resultados (paginação)
	List<T> listar(int primeiraPosicao, int maximoResultado);
	
}