package com.project.models;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="project")
public class Project  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_project")
	private long id_project;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;

    @ManyToOne
	@JoinColumn(name ="id_company")
	private Company id_company;
	
	 @ManyToOne
    @JoinColumn(name="id_service")
	private Service id_service;
	
    @ManyToOne
	@JoinColumn(name="id_market")
	 private Market id_market;
	
	
	@OneToMany(mappedBy = "project")
	private Set<Task> task;


	/**
	 * @return the id_project
	 */
	public long getId_project() {
		return id_project;
	}


	/**
	 * @param id_project the id_project to set
	 */
	public void setId_project(long id_project) {
		this.id_project = id_project;
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


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the id_company
	 */
	public Company getId_company() {
		return id_company;
	}


	/**
	 * @param id_company the id_company to set
	 */
	public void setId_company(Company id_company) {
		this.id_company = id_company;
	}


	

	/**
	 * @return the id_service
	 */
	public Service getId_service() {
		return id_service;
	}


	/**
	 * @param id_service the id_service to set
	 */
	public void setId_service(Service id_service) {
		this.id_service = id_service;
	}


	/**
	 * @return the id_market
	 */
	public Market getId_market() {
		return id_market;
	}


	/**
	 * @param id_market the id_market to set
	 */
	public void setId_market(Market id_market) {
		this.id_market = id_market;
	}


	
}
