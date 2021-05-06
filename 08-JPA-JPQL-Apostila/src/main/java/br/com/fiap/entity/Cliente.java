package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EAD_CLIENTE")
@SequenceGenerator(name="seqCliente", sequenceName="SEQ_TB_EAD_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCliente")
	private int id;
	
	@Column(name="nm_cliente", length = 80, nullable=false)
	private String nome;
	
	@Column(length=11,nullable=false, name="nr_cpf")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_endereco")
	private Endereco endereco;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Pacote> pacotes;

	public Cliente(String nome, String cpf, Calendar dataNascimento, Endereco endereco, List<Pacote> pacotes) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.pacotes = pacotes;
	}
	
	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	
}
