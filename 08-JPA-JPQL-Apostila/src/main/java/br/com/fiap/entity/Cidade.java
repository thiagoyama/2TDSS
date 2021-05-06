package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EAD_CIDADE")
@SequenceGenerator(name="seqCidade", sequenceName="SEQ_TB_EAD_CIDADE", allocationSize=1)
public class Cidade {

	@Id
	@Column(name="cd_cidade")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCidade")
	private int id;
	
	@Column(nullable=false, length = 100, name="nm_cidade")
	private String nome;
	
	@Column(length=2,nullable=false, name="ds_uf")
	private String uf;
	
	@Column(name="nr_ddd")
	private Integer ddd;
	
	@Column(name="nr_habitantes")
	private Integer nrHabitantes;

	public Cidade(String nome, String uf, Integer ddd, Integer nrHabitantes) {
		super();
		this.nome = nome;
		this.uf = uf;
		this.ddd = ddd;
		this.nrHabitantes = nrHabitantes;
	}

	public Cidade() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNrHabitantes() {
		return nrHabitantes;
	}

	public void setNrHabitantes(Integer nrHabitantes) {
		this.nrHabitantes = nrHabitantes;
	}

	public int getId() {
		return id;
	}

}
