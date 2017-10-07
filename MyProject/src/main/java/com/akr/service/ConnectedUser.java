package com.akr.service;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.akr.dao.CollabDao;
import com.akr.model.Collab;


@ManagedBean(name="ConnectedUser")
@SessionScoped
public class ConnectedUser {

	Collab connectedUser;

	@ManagedProperty("#{collabDao}")
	CollabDao collabDao;

	public Collab getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(Collab connectedUser) {
		this.connectedUser = connectedUser;
	}

	public CollabDao getcollabDao() {
		return collabDao;
	}

	public void setcollabDao(CollabDao collabDao) {
		this.collabDao = collabDao;
	}

	@PostConstruct
	public void init(){
		try {
			String userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
			if(!userName.isEmpty()){
				connectedUser = collabDao.findByUserName(userName);
			}else
			{
				connectedUser = new Collab();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
