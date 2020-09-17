package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.client.ResourceAccessException;

import com.project.models.Service;
import com.project.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ServiServiceImpl implements ServiService {

private final ServiceRepository serviceRepository;
	
	@Override
	public List<Service> getAllService(){
		return serviceRepository.findAll();
	}
		
	
	@Override
	public Service createService(Service market) {
		return serviceRepository.save(market);
	}
	
	@Override
	public Service updateService(Service market) {
		Service serviceUpdate = serviceRepository.findById(market.getId_service()).orElseThrow(()-> new ResourceAccessException("No se encontro el servicio con el id:" + market.getId_service()));
		
		serviceUpdate.setId_service(market.getId_service());
		serviceUpdate.setName(market.getName());
		
		serviceRepository.save(serviceUpdate);
		return serviceUpdate;
	}
	
	@Override
	public void deleteService(long id) {
		Service service  = serviceRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro el market con el id:" + id));
		serviceRepository.delete(service);
	}

}
