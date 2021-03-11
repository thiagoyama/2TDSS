package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Funcionario;
import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.FuncionarioMySqlDao;

// JSP <-> Servlet FuncionarioDao <-> DAO <-> Banco de dados

public class TesteInterface {

	public static void main(String[] args) {
		
		//Instanciar um objeto do tipo FuncionarioDao
		FuncionarioDao dao = new FuncionarioMySqlDao();
		
		//Chamar o método de atualizar funcionário
		dao.atualizar(new Funcionario());
		
	}
	
}