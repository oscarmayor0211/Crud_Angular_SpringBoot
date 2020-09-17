package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.project.models.Company;

import com.project.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
private final CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompany(){
		return companyRepository.findAll();
	}
		
	
	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}
	
	@Override
	public Company updateCompany(Company company) {
		Company companyUpdate = companyRepository.findById(company.getId_company()).orElseThrow(()-> new ResourceAccessException("No se encontro la compañia con el id:" + company.getId_company()));
		
		companyUpdate.setId_company(company.getId_company());
		companyUpdate.setName(company.getName());
		
		companyRepository.save(companyUpdate);
		return companyUpdate;
	}
	
	@Override
	public void deleteCompany(long id) {
		Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro la compañia con el id:" + id));
		companyRepository.delete(company);
	}
}
