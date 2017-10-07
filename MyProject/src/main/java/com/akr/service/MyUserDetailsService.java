package com.akr.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akr.dao.CollabDao;
import com.akr.dao.UserDao;
import com.akr.dao.UserRoleDao;
import com.akr.model.Collab;
import com.akr.model.Role;
import com.akr.model.User;
import com.akr.model.UserRole;

@Service
@SessionScoped
@Transactional
@ManagedBean(name="userDetailsService")
public class MyUserDetailsService{

	@ManagedProperty("#{userDao}")
	 private UserDao userDao;
	 
	@ManagedProperty("#{collabDao}")
	 private CollabDao collabDao;
	
	@ManagedProperty("#{userRoleDao}")
	 private UserRoleDao userRoleDao;
	
	 private User user = new User();
	 private Collab collab = new Collab();
	 UserRole UR = new UserRole();
	 private List<User> userList   = new ArrayList<User>();
	 
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public CollabDao getCollabDao() {
		return collabDao;
	}

	public void setCollabDao(CollabDao collabDao) {
		this.collabDao = collabDao;
	}

	public List<User> getUserList() {
		 userList = listUsers();
		 return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Collab getCollab() {
		return collab;
	}

	public void setCollab(Collab collab) {
		this.collab = collab;
	}
	
	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public UserRole getUR() {
		return UR;
	}

	public void setUR(UserRole uR) {
		UR = uR;
	}

	public boolean verifPassword(String password, String passwordConfirm) {
		if (password.equalsIgnoreCase(passwordConfirm))
			return true;
		else
			return false;
	}

	public void addUser() {
		if (verifPassword(user.getPassword(),user.getPasswordConfirm())) {
			
		    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		    user.setPassword(passwordEncoder.encode(user.getPassword()));  
		    user.setEnabled(true);
			UR.setRole(new Role(2, "ROLE_USER"));
			UR.setUser(user);
			userDao.addUser(user);
			userRoleDao.addUserRole(UR);
			UR = new UserRole();
			userDao.findAllUsers();
		} 
	}

	@Transactional(readOnly = true)
	public List<User> listUsers() {
		 userList = userDao.findAllUsers();
		 return userList;
	}
	
	public String deleteAction(User u) {
		userDao.deleteUser(u);
		return null;
	}

	public void updateList() {
		for(User user: userList)
			userDao.updateUser(user);
	}

	public String register() {
		try {
			addUser();
			collab.setUser(user);
			collabDao.addCollab(collab);
			collab= new Collab();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Echec de l'inscription, " + e.getMessage(), ""));
			return null;
		}
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Succès de l'inscription !!!", ""));
		return "login";
	}
	
}