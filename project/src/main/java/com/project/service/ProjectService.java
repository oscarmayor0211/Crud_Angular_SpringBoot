/**
 * 
 */
package com.project.service;

import java.util.List;

import com.project.models.Project;


/**
 * @author Oscar Mayor
 *
 */
public interface ProjectService {

	Project createProject(Project project);
	
	Project updateProject(Project project);
	
	List<Project> getAllProject();
	
	Project getProjectById(long id);
	
	void deleteProject(long id);
}
