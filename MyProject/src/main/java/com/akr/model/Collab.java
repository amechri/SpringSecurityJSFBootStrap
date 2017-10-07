package com.akr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 

@Entity
@Table(name="APP_COLLAB")
public class Collab implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Collab", unique = true, nullable = false)
    private int id_Collab;
	
    private String nom;
    
    private String prenom;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaiss;
    
    private int sexe;
    
    @OneToOne
	@JoinColumn(name = "username", nullable = false)
    private User user; 
    
    public int getId_Collab() {
        return id_Collab;
    }
 
    public void setId_Collab(int id_Collab) {
        this.id_Collab = id_Collab;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}