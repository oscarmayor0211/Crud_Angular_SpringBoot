package com.project.models;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task implements Serializable{



	
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_task")
	private long id_task;
	
	@Column(name="title")
	private String title;
	
    @ManyToOne
	@JoinColumn(name="id_project")	
	private Project project;

	/**
	 * @return the id_task
	 */
	public long getId_task() {
		return id_task;
	}

	/**
	 * @param id_task the id_task to set
	 */
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

   
    
    
}
