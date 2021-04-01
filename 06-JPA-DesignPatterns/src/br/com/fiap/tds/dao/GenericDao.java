package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

//GenericDao<Cliente, Integer> dao = ...

public interface GenericDao<E,K> {

	void create(E entidade);
	
	E search(K id) throws EntityNotFoundException;
	
	void update(E entidade);
	
	void delete(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}