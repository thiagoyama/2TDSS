package br.com.fiap.tds.dao;

import br.com.fiap.tds.bean.Funcionario;

public class FuncionarioOracleDao implements FuncionarioDao {

	@Override
	public void atualizar(Funcionario funcionario) {
		System.out.println("Atualizando no oracle");
	}

	@Override
	public void deletar(int id) {
		System.out.println("Removendo do oracle");
	}
	
}
