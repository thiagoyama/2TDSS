package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EAD_PACOTE")
@SequenceGenerator(name="seqPacote", sequenceName="SEQ_TB_EAD_PACOTE", allocationSize=1)
public class Pacote {

	@Id
	@Column(name="cd_pacote")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPacote")
	private int id;
	
	@Column(name="ds_pacote", length = 200, nullable=false)
	private String descricao;
	
	@Column(name="dt_saida",nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataSaida;
	
	@Column(name="qt_dias")
	private Integer qtdDias;
	
	@Column(name="vl_pacote")
	private Float preco;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_transporte")
	private Transporte transporte;
	
	public Pacote(String descricao, Integer qtdDias) {
		this.descricao = descricao;
		this.qtdDias = qtdDias;
	}
	
	public Pacote(String descricao, Calendar dataSaida, Integer qtdDias, Float preco, Transporte transporte) {
		super();
		this.descricao = descricao;
		this.dataSaida = dataSaida;
		this.qtdDias = qtdDias;
		this.transporte = transporte;
		this.preco = preco;
	}
	
	public Pacote() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(Integer qtdDias) {
		this.qtdDias = qtdDias;
	}

	public int getId() {
		return id;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
