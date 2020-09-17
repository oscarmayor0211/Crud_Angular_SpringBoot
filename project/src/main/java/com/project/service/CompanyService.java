/**
 * 
 */
package com.project.service;

import java.util.List;

import com.project.models.Company;

/**
 * @author Oscar Mayor
 *
 */
public interface CompanyService {


    Company createCompany(Company company);
	
    Company updateCompany(Company company);
		
	List<Company> getAllCompany();
		
	void deleteCompany(long id);
}
