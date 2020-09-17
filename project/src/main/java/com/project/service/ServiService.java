package com.project.service;

import java.util.List;

import com.project.models.Service;



public interface ServiService {

	  Service createService(Service service);
		
	  Service updateService(Service service);
			
	  List<Service> getAllService();
			
      void deleteService(long id);
}
