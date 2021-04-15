package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.GrupoChallengeDao;
import br.com.fiap.tds.entity.GrupoChallenge;

public class GrupoChallengeDaoImpl 
			extends GenericDaoImpl<GrupoChallenge, Integer> implements GrupoChallengeDao {

	public GrupoChallengeDaoImpl(EntityManager em) {
		super(em);
	}

}
