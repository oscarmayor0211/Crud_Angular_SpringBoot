/**
 * 
 */
package com.project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Project;
import com.project.service.ProjectService;

import lombok.RequiredArgsConstructor;

/**
 * @author Oscar Mayor
 *
 */
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
	private final ProjectService projectService;
				
	//Rutas projects
	@GetMapping
	ResponseEntity<List<Project>> getAllProjects(){
		return ResponseEntity.ok().body(projectService.getAllProject());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Project> getProjectById(@PathVariable Long id){
		return ResponseEntity.ok().body(projectService.getProjectById(id));
	}
	
	@PostMapping
	ResponseEntity<Project> createProject(@RequestBody Project project){
		return ResponseEntity.ok().body(this.projectService.createProject(project));
	}
	
	@PutMapping("/{id}/edit")
	ResponseEntity<Project> updateProject(@PathVariable Long id , @RequestBody Project project){
		project.setId_project(id);
		return ResponseEntity.ok().body(this.projectService.updateProject(project));
	}
	
	@DeleteMapping("/{id}/delete")
	ResponseEntity<?> deleteProject(@PathVariable Long id){
		this.projectService.deleteProject(id);
		return ResponseEntity.noContent().build();
	}

}
