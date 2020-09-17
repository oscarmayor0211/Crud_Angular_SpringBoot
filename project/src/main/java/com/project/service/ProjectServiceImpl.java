/**
 * 
 */
package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.project.models.Project;

import com.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Oscar Mayor
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
	private final ProjectRepository projectRepository;


	@Override
	public List<Project> getAllProject(){
		return projectRepository.findAll();
	}
	
	
	
	@Override
	public Project getProjectById(long id) {
		return projectRepository.findById(id).orElseThrow(()-> new ResourceAccessException("No existe el proyecto con el id:"+ id));
	}
	
	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	@Override
	public Project updateProject(Project project) {
		Project ProjectUpdate = projectRepository.findById(project.getId_project()).orElseThrow(()-> new ResourceAccessException("No se encontro el proyecto con el id:" + project.getId_project()));
		
		ProjectUpdate.setId_project(project.getId_project());
		ProjectUpdate.setName(project.getName());
		ProjectUpdate.setDescription(project.getDescription());
		ProjectUpdate.setId_company(project.getId_company());
		ProjectUpdate.setId_service(project.getId_service());
		ProjectUpdate.setId_market(project.getId_market());
		
		projectRepository.save(ProjectUpdate);
		return ProjectUpdate;
	}
	
	@Override
	public void deleteProject(long id) {
		Project empleado = projectRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro el proyecto con el id:" + id));
		projectRepository.delete(empleado);
	}

}
