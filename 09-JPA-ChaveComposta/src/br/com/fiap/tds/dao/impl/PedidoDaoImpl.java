package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.PedidoDao;
import br.com.fiap.tds.entity.Pedido;

public class PedidoDaoImpl extends GenericDaoImpl<Pedido, Integer> implements PedidoDao {

	public PedidoDaoImpl(EntityManager em) {
		super(em);
	}

}
