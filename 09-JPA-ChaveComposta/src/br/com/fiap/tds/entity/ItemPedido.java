package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Definir a classe que mapeia a chave composta
@IdClass(ItemPedidoPK.class)

@Entity
@Table(name="TB_ITEM_PEDIDO")
@SequenceGenerator(name="item", sequenceName = "SQ_ITEM_PEDIDO", allocationSize = 1)
public class ItemPedido {
	
	@Id
	@Column(name="cd_item")
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_produto")
	private Produto produto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	@Column(name="vl_item", nullable = false)
	private Double valor;
	
	@Column(name="qt_item", nullable = false)
	private Integer quantidade;
	
	public ItemPedido() {}

	public ItemPedido(Produto produto, Pedido pedido, Double valor, Integer quantidade) {
		this.produto = produto;
		this.pedido = pedido;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
