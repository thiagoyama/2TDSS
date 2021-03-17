package br.com.fiap.tds.bean;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome="TB_CARRO")
public class Carro {
	
	@Coluna(nome="ds_cor", tipo ="VARCHAR", tamanho = 30)
	private String cor;
	
	@Coluna(nome="ds_modelo", tipo = "VARCHAR")
	private String modelo;
	
	@Coluna(nome="nr_ano", tipo = "NUMBER")
	private int ano;

	//CTRL + 3 -> ggas
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}