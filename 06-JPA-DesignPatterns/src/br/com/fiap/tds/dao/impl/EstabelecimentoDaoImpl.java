package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.EstabelecimentoDao;
import br.com.fiap.tds.entity.Estabelecimento;

public class EstabelecimentoDaoImpl extends GenericDaoImpl<Estabelecimento, Integer> 
															implements EstabelecimentoDao {

	public EstabelecimentoDaoImpl(EntityManager em) {
		super(em);
	}

}