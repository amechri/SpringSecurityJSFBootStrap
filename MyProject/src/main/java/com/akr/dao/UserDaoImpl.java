package com.akr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akr.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void addUser(User user) {
		create(user);
		logger.info("User Ajoutée =" + user);
	}

	@Override
	public User updateUser(User user) {
		update(user);
		logger.info("User Modifié =" + user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
		logger.info("User Supprimé =" + user);
	}

	@Override
	public List<User> findAllUsers() {
		return findAll();
	}

}