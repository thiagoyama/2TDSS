package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_FORNECEDOR")
@SequenceGenerator(name="for", sequenceName = "SQ_TB_FORNECEDOR", allocationSize = 1)
public class Fornecedor {
	
	@Id
	@Column(name="cd_fornecedor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "for")
	private int codigo;
	
	@Column(name="nm_fornecedor", length = 60, nullable = false)
	private String nome;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	public Fornecedor() {}
	
	public Fornecedor(String nome) {
		this.nome = nome;
	}

	public Fornecedor(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
