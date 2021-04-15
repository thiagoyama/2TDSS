package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ProjetoChallengeDao;
import br.com.fiap.tds.entity.ProjetoChallenge;

public class ProjetoChallengeDaoImpl 
		extends GenericDaoImpl<ProjetoChallenge, Integer> implements ProjetoChallengeDao {

	public ProjetoChallengeDaoImpl(EntityManager em) {
		super(em);
	}

}
