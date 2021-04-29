package br.comfiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="caso", sequenceName = "SQ_TAB_CASO_TESTE", allocationSize = 1)
public class CasoTeste {
	
	@Id
	@Column(name="cod_caso_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso")
	private int codigo;
	
	@Column(name="nom_caso_teste")
	private String nome;
	
	@Column(name="des_caso_teste")
	private String descricao;

	@ManyToOne
	@JoinColumn(name="cod_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy = "casoTeste", cascade = CascadeType.ALL)
	private List<ItemTeste> itensTeste;
	
	public CasoTeste() {}
	
	public CasoTeste(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public void addItemTeste(ItemTeste item) {
		if (itensTeste == null)
			itensTeste = new ArrayList<>();
		
		itensTeste.add(item);
		item.setCasoTeste(this);
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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}
	
	
}
