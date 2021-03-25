package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="end", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end")
	private int codigo;
	
	@Column(name="nr_cep", length = 8, nullable = false)
	private String cep;
	
	@Column(name="ds_logradouro", length = 50, nullable = false)
	private String logradouro;
	
	@Column(name="nr_endereco")
	private int numero;
	
	@Column(name="st_ativo")
	private boolean ativo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_endereco", length = 50)
	private TipoEndereco tipo;
	
	@CreationTimestamp //Cadastrar a data de forma automática
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;
	
	public Endereco() {}
	
	//CTRL + 3 -> gcuf (construtor)
	public Endereco(String cep, String logradouro, int numero, boolean ativo, TipoEndereco tipo) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.ativo = ativo;
		this.tipo = tipo;
	}
	
	public Endereco(int codigo, String cep, String logradouro, int numero, boolean ativo, TipoEndereco tipo) {
		super();
		this.codigo = codigo;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.ativo = ativo;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return "Código: " + codigo + "\nCEP: " + cep + "\nLogradouro: " +
				logradouro + "\nNúmero: " + numero + "\nAtivo: " + ativo + 
				"\nTipo: " + tipo + 
				"\nData cadastro: " + sdf.format(dataCadastro.getTime());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
