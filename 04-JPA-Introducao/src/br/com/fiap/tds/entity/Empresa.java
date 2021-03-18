package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="TB_EMPRESA")
@SequenceGenerator(name="empresa",
						sequenceName = "SQ_TB_EMPRESA", allocationSize = 1)
//sequenceName -> nome no banco de dados
//name -> nome no java, no generator
//allocationSize -> incremento
public class Empresa {
	
	@Id
	@Column(name="cd_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	private int codigo;

	@Column(name="nm_empresa", nullable = false, length = 100)
	private String nome;
	
	@Column(name="nr_cnpj", nullable = false, length = 26)
	private String cnpj;
	
	@Column(name="nr_funcionarios")
	private int quantidadeFuncionarios;
	
	@Column(name="ds_endereco", length = 60)
	private String endereco;
	
	@Temporal(TemporalType.DATE) //Armazena somente a data
	@Column(name="dt_fundacao", nullable = false)
	private Calendar dataFundacao;
	
	@Transient //Não é uma coluna na tabela no banco
	private int anosVida;
	
	@Lob //BLOB no oracle, para gravar arquivos
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 8)
	private TipoEmpresa tipo;
	
	//CTRL + 3 -> ggas

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getAnosVida() {
		return anosVida;
	}

	public void setAnosVida(int anosVida) {
		this.anosVida = anosVida;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public TipoEmpresa getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpresa tipo) {
		this.tipo = tipo;
	}
	
}
