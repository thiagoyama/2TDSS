package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.entity.Produto;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao {

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
	}

}
