package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int codigo;
	
	@Column(name="nm_aluno", nullable = false, length = 100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="ds_papel", length = 40)
	private String papel;
	
	//Mapeamento do relacionamento muitos para um
	@ManyToOne
	@JoinColumn(name="cd_grupo", nullable = false)
	private GrupoChallenge grupo;
	
	//Mapeamento do relacionamento muitos para muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	//JoinTable -> cofigura a tabela associativa
	//name -> Nome da tabela associativa
	//joinColumns -> configura a coluna da fk/pk da classe que estamos
	//inverseJoinColumns -> configura a coluna da fk/pk da classe do outro lado da relação
	@JoinTable(name="TB_ALUNO_NANO_COURSE", 
		joinColumns = @JoinColumn(name="nr_rm"),
		inverseJoinColumns = @JoinColumn(name="cd_curso"))
	private List<NanoCourse> cursos;
	
	public Aluno() {}

	public Aluno(String nome, Calendar dataNascimento, String papel) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.papel = papel;
	}

	public Aluno(int codigo, String nome, Calendar dataNascimento, String papel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.papel = papel;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public GrupoChallenge getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoChallenge grupo) {
		this.grupo = grupo;
	}

	public List<NanoCourse> getCursos() {
		return cursos;
	}

	public void setCursos(List<NanoCourse> cursos) {
		this.cursos = cursos;
	}
	
}
