/**
 * 
 */
package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Project;


/**
 * @author Oscar Mayor
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
