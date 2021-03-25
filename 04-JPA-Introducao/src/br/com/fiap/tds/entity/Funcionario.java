package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func")
	private int codigo;
	
	@Column(name="nm_funcionario", nullable = false, length = 100)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo_contrato", nullable = false)
	private TipoContrato contrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_contratacao", nullable = false)
	private Calendar dataContratacao;
	
	@Column(name="vl_salario")
	private double salario;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_cargo", length = 50)
	private String cargo;
	
	@Column(name="st_deficiente")
	private boolean deficiente;
	
	//CTRL + 3 -> ggas (gets e sets)

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

	public TipoContrato getContrato() {
		return contrato;
	}

	public void setContrato(TipoContrato contrato) {
		this.contrato = contrato;
	}

	public Calendar getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Calendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isDeficiente() {
		return deficiente;
	}

	public void setDeficiente(boolean deficiente) {
		this.deficiente = deficiente;
	}
	
}
