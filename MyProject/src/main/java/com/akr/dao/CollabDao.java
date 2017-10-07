package com.akr.dao;

import java.util.List;

import com.akr.model.Collab;


public interface CollabDao {

	Collab findByNom(String nom);
	
	Collab findByUserName(String username);
	
	void addCollab(Collab collab);
	
	Collab updateCollab(Collab collab);
	
	void deleteCollab(Collab collab);
	
	List<Collab> findAllCollab();

}