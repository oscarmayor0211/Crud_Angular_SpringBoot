package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
