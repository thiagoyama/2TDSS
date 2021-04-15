package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO_CHALLENGE")
@SequenceGenerator(name="grupo", sequenceName = "SQ_TB_GRUPO_CHALLENGE", allocationSize = 1)
public class GrupoChallenge {
	
	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo")
	private int codigo;
	
	@Column(name="nm_grupo", nullable = false, length = 50)
	private String nome;
	
	//Mapear o relacionamento um-para-um
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_projeto")
	private ProjetoChallenge projeto;
	
	public GrupoChallenge() {}
	
	public GrupoChallenge(String nome, ProjetoChallenge projeto) {
		super();
		this.nome = nome;
		this.projeto = projeto;
	}

	public GrupoChallenge(int codigo, String nome, ProjetoChallenge projeto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.projeto = projeto;
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

	public ProjetoChallenge getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoChallenge projeto) {
		this.projeto = projeto;
	}
	
}