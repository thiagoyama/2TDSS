package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.SistemaDao;
import br.comfiap.tds.entity.Sistema;

public class SistemaDaoImpl extends GenericDaoImpl<Sistema, Integer> implements SistemaDao {

	public SistemaDaoImpl(EntityManager em) {
		super(em);
	}

}
