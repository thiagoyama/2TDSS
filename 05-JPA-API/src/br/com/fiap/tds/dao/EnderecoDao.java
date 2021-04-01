package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EnderecoNotFoundException;

//Interface -> desacoplar os objetos, diminuir a dependência
// View - Controller (EnderecoDao) - DAO - Banco

public interface EnderecoDao {

	void create(Endereco endereco);
	
	Endereco search(int id) throws EnderecoNotFoundException;
	
	void update(Endereco endereco);
	
	void delete(int id) throws EnderecoNotFoundException;
	
	void commit() throws CommitException;
	
}