package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_NANO_COURSE")
@SequenceGenerator(name="nano", sequenceName = "SQ_TB_NANO_COURSE", allocationSize = 1)
public class NanoCourse {
	
	@Id
	@Column(name="cd_curso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nano")
	private int codigo;
	
	@Column(name="nm_curso", length = 90, nullable = false)
	private String nome;
	
	@Column(name="nr_creditos", nullable = false)
	private Integer creditos;
	
	@Column(name="nr_carga_horaria", nullable = false)
	private Integer cargaHoraria;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_categoria", length = 40, nullable = false)
	private Categoria categoria;
	
	//Mapear o relacionamento muitos para muitos bidirecional
	@ManyToMany(mappedBy = "cursos")
	private List<Aluno> alunos;
	
	public NanoCourse() {}
	
	public NanoCourse(String nome, Integer creditos, Integer cargaHoraria, Categoria categoria) {
		super();
		this.nome = nome;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.categoria = categoria;
	}

	public NanoCourse(int codigo, String nome, Integer creditos, Integer cargaHoraria, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.categoria = categoria;
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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
