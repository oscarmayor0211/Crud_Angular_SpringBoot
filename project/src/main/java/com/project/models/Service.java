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
@Table(name ="service")

public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_service")
	private long id_service;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "id_service")
	 Set<Project> projects;

	/**
	 * @return the id_service
	 */
	public long getId_service() {
		return id_service;
	}

	/**
	 * @param id_service the id_service to set
	 */
	public void setId_service(long id_service) {
		this.id_service = id_service;
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
