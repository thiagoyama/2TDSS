package br.com.fiap.tds.entity;

import java.io.Serializable;

//Classe que mapeia a chave composta da tabela
//Possui os atributos que formam a chave composta e com o mesmo nome dos atributos da entidade

public class ItemPedidoPK implements Serializable {

	private int codigo;
	
	private int produto;
	
	private int pedido;
	
	public ItemPedidoPK() {}

	public ItemPedidoPK(int codigo, int produto, int pedido) {
		this.codigo = codigo;
		this.produto = produto;
		this.pedido = pedido;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + pedido;
		result = prime * result + produto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (codigo != other.codigo)
			return false;
		if (pedido != other.pedido)
			return false;
		if (produto != other.produto)
			return false;
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	
}