package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO {

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.transporte = :t", Pacote.class);
		query.setParameter("t", transporte);
		return query.getResultList();
	}

	@Override
	public List<Object[]> buscarPorPrecoMenor(float preco) {
		return em.createQuery("select p.descricao, p.qtdDias from Pacote p where p.preco < :pPreco", Object[].class)
				.setParameter("pPreco", preco)
				.getResultList();
	}

	//Utilizar o construtor para obter um Pacote com os valores que queremos
	@Override
	public List<Pacote> buscarPorPrecoMenor2(float preco) {
		return em.createQuery("select new Pacote(p.descricao, p.qtdDias) from Pacote p where p.preco < :pPreco", Pacote.class)
				.setParameter("pPreco", preco)
				.getResultList();
	}

	@Override
	public List<String> buscarPorPrecoMenor3(float preco) {
		return em.createQuery("select p.descricao from Pacote p where p.preco < :p", String.class)
				.setParameter("p", preco)
				.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public double somarPrecoPorTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote p where p.transporte = :t", Double.class)
				.setParameter("t", transporte)
				.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pacote> buscarPorQtdDiasMaiorEPrecoMenor(int qtd, float preco) {
		return em.createNativeQuery("select * from tb_ead_pacote where qt_dias > :d and vl_pacote < :v", Pacote.class)
				.setParameter("d", qtd)
				.setParameter("v", preco)
				.getResultList();
	}

}
