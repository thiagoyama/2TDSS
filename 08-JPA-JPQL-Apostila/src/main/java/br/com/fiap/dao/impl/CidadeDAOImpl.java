package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
		//Configurar o máximo de resultado para 2
		query.setMaxResults(2);
		//Executar a query
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorDdd(int ddd) {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery("from Cidade c where c.ddd = :numero", Cidade.class);
		//Setar o parametro
		query.setParameter("numero", ddd);
		//Executar a query
		return query.getResultList();
	}

}
