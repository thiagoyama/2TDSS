package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;
import br.com.fiap.tds.entity.Pedido;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar todas as entidades relacionadas
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ItemPedidoDao
		ItemPedidoDao itemDao = new ItemPedidoDaoImpl(em);
		
		//Instanciar um produto
		Produto produto = new Produto("Suco de Laranja");
		
		//Instanciar um pedido
		Pedido pedido = new Pedido(Calendar.getInstance(), 10.0);
		
		//Instanciar um item de pedido com o produto e pedido
		ItemPedido item = new ItemPedido(produto, pedido, 5.0, 2);
		
		try {
			//Cadastrar o item
			itemDao.create(item);
			itemDao.commit();
			System.out.println("Item, produto e pedido cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um item de pedido pela PK
			ItemPedidoPK pk = new ItemPedidoPK(1, 1, 1);
			ItemPedido itemPedido = itemDao.search(pk);
			System.out.println(itemPedido.getProduto().getNome() + " " + itemPedido.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
