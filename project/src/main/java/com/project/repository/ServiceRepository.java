package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
