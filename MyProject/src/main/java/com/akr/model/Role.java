package com.akr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ROLES")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role", unique = true, nullable = false)
	private Integer id_role;
	
	private String libelle;
	
	public Role() {
	}


	public Role(Integer id_role, String libelle) {
		this.id_role = id_role;
		this.libelle = libelle;
	}


	public Integer getId_role() {
		return id_role;
	}


	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




}
