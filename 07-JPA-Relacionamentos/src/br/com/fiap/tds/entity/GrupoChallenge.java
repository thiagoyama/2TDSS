package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToOne
	@JoinColumn(name = "cd_projeto", nullable = false)
	private ProjetoChallenge projeto;

}