package com.akr.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akr.model.UserRole;

@Repository("userRoleDao")
@Transactional
public class UserRoleImpl extends AbstractHibernateDao<UserRole> implements UserRoleDao {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUserRole(UserRole userRole) {
		create(userRole);
		logger.info("userRole Ajoutée =" + userRole);
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		delete(userRole);
		logger.info("userRole Supprimé =" + userRole);
	}

}