package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO_CHALLENGE")
@SequenceGenerator(name="projeto", sequenceName = "SQ_TB_PROJETO_CHALLENGE", allocationSize = 1)
public class ProjetoChallenge {

	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(generator = "projeto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_projeto", length = 60, nullable = false)
	private String nome;
	
	@Column(name="ds_projeto", length = 400)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio", nullable = false)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim", nullable = false)
	private Calendar dataFim;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 20)
	private TipoProjeto tipo;
	
	@Column(name="vl_nota")
	private Float nota;
	
	//Mapear o relacionamento um-para-um bidirecional
	//mappedBy -> sempre utilizado no bidirecional
	//mappedBy -> nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "projeto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private GrupoChallenge grupo;

	public ProjetoChallenge() {}
	
	public ProjetoChallenge(String nome, String descricao, 
			Calendar dataInicio, Calendar dataFim, TipoProjeto tipo,
			Float nota) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.nota = nota;
	}

	public ProjetoChallenge(int codigo, String nome, String descricao, 
			Calendar dataInicio, Calendar dataFim,
			TipoProjeto tipo, Float nota) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.nota = nota;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public TipoProjeto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProjeto tipo) {
		this.tipo = tipo;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

}
