 /**
 * 
 */
package com.project.models;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * @author Oscar Mayor
 *
 */
@Entity
@Table(name = "company")
public class Company implements Serializable  {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_company") 
	private long id_company;
	
	
	@Column(name ="name")
	private String name;
	
	@OneToMany(mappedBy = "id_company")
	 Set<Project> projects;

	

	/**
	 * @return the id_company
	 */
	public long getId_company() {
		return id_company;
	}

	/**
	 * @param id_company the id_company to set
	 */
	public void setId_company(long id_company) {
		this.id_company = id_company;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	
	
}
