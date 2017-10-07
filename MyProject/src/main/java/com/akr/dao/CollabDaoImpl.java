package com.akr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akr.model.Collab;

@Repository("collabDao")
@Transactional
public class CollabDaoImpl extends AbstractHibernateDao<Collab> implements CollabDao {

	private static final Logger logger = LoggerFactory.getLogger(CollabDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Collab findByNom(String nom) {

		List<Collab> collabs = new ArrayList<Collab>();

		collabs = sessionFactory.getCurrentSession()
				.createQuery("from Collab where nom=?")
				.setParameter(0, nom).list();

		if (collabs.size() > 0) {
			return collabs.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void addCollab(Collab collab) {
		create(collab);
		logger.info("Collab Ajoutée =" + collab);
	}

	@Override
	public Collab updateCollab(Collab collab) {
		update(collab);
		logger.info("Collab Modifié =" + collab);
		return collab;
	}

	@Override
	public void deleteCollab(Collab collab) {
		delete(collab);
		logger.info("Collab Supprimé =" + collab);
	}

	@Override
	public List<Collab> findAllCollab() {
		return findAll();
	}

	@Override
	public Collab findByUserName(String username) {
		List<Collab> collabs = new ArrayList<Collab>();

		collabs = sessionFactory.getCurrentSession()
				.createQuery("from Collab where username=?")
				.setParameter(0, username).list();

		if (collabs.size() > 0) {
			return collabs.get(0);
		} else {
			return null;
		}
	}

}