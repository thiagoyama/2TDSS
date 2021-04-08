package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.FornecedorDao;
import br.com.fiap.tds.entity.Fornecedor;

public class FornecedorDaoImpl 
		extends GenericDaoImpl<Fornecedor, Integer> implements FornecedorDao {

	public FornecedorDaoImpl(EntityManager em) {
		super(em);
	}

}
