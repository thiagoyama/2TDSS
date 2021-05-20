package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;

public class ItemPedidoDaoImpl extends 
						GenericDaoImpl<ItemPedido, ItemPedidoPK> implements ItemPedidoDao {

	public ItemPedidoDaoImpl(EntityManager em) {
		super(em);
	}

}