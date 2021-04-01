package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ESTABELECIMENTO")
@SequenceGenerator(name="est", sequenceName = "SQ_TB_ESTABELECIMENTO", allocationSize = 1)
public class Estabelecimento {
	
	@Id
	@Column(name="cd_estabelecimento")
	@GeneratedValue(generator = "est", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_estabelecimento", nullable = false, length = 70)
	private String nome;
	
	@Column(name="nr_cnpj", length = 22, nullable = false)
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 20)
	private Tipo tipo;
	
	public Estabelecimento() {}
	
	public Estabelecimento(String nome, String cnpj, Tipo tipo) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}
	
	public Estabelecimento(int codigo, String nome, String cnpj, Tipo tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
