package br.comfiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName = "SQ_TAB_SISTEMA", allocationSize = 1)
public class Sistema {
	
	@Id
	@Column(name="cod_sistema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sistema")
	private int codigo;
	
	@Column(name="nom_sistema")
	private String nome;
	
	@OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL)
	private List<CasoTeste> casosTeste;
	
	public Sistema() {}
	
	public Sistema(String nome) {
		this.nome = nome;
	}
	
	public void addCasoTeste(CasoTeste caso) {
		if (casosTeste == null)
			casosTeste = new ArrayList<>();
		
		casosTeste.add(caso);
		caso.setSistema(this);
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

	public List<CasoTeste> getCasosTeste() {
		return casosTeste;
	}

	public void setCasosTeste(List<CasoTeste> casosTeste) {
		this.casosTeste = casosTeste;
	}
	
}
