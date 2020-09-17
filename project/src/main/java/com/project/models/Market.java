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

@Entity
@Table(name="market")

public class Market  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_market")
	private long id_market;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "id_market")
	private  Set<Project> project;

	/**
	 * @return the id_market
	 */
	public long getId_market() {
		return id_market;
	}

	/**
	 * @param id_market the id_market to set
	 */
	public void setId_market(long id_market) {
		this.id_market = id_market;
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
