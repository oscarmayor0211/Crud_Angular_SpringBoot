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

import com.project.models.Company;
import com.project.service.CompanyService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects/companys")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

	private final CompanyService companyService;

	
	//Rutas company
		@GetMapping("/company")
		ResponseEntity<List<Company>> getAllCompany(){
			return ResponseEntity.ok().body(companyService.getAllCompany());
		}
		
	
		@PostMapping
		ResponseEntity<Company> createCompany(@RequestBody Company company){
			return ResponseEntity.ok().body(this.companyService.createCompany(company));
		}
		
		@PutMapping("/{id}/edit")
		ResponseEntity<Company> updateCompany(@PathVariable Long id , @RequestBody Company company){
			company.setId_company(id);
			return ResponseEntity.ok().body(this.companyService.updateCompany(company));
		}
		
		@DeleteMapping("/{id}/delete")
		ResponseEntity<?> deleteMarket(@PathVariable Long id){
			this.companyService.deleteCompany(id);
			return ResponseEntity.noContent().build();
		}
}
