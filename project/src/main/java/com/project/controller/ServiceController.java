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

import com.project.models.Service;
import com.project.service.ServiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects/services")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
private final ServiService serviService;

	
	//Rutas Service
		@GetMapping("/service")
		ResponseEntity<List<Service>> getAllService(){
			return ResponseEntity.ok().body(serviService.getAllService());
		}
		
	
		@PostMapping
		ResponseEntity<Service> createService(@RequestBody Service service){
			return ResponseEntity.ok().body(this.serviService.createService(service));
		}
		
		@PutMapping("/{id}/edit")
		ResponseEntity<Service> updateService(@PathVariable Long id , @RequestBody Service service){
			service.setId_service(id);
			return ResponseEntity.ok().body(this.serviService.updateService(service));
		}
		
		@DeleteMapping("/{id}/delete")
		ResponseEntity<?> deleteService(@PathVariable Long id){
			this.serviService.deleteService(id);
			return ResponseEntity.noContent().build();
		}
}
