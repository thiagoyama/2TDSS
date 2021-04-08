package br.com.fiap.tds.entity;

import java.util.Calendar;

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
	//Define o atributo que mapeia a relação no BD
	@OneToOne(mappedBy = "projeto")
	private GrupoChallenge grupo;
	
}
