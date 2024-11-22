package com.vb.ms.company.services.interfaces;

import java.util.List;

import com.vb.ms.company.dto.CompanyDTO;
import com.vb.ms.company.modals.Company;
import com.vb.ms.company.modals.Job;


public interface CompanyService {
	
	public List<CompanyDTO> findAllCompanies();
	
	
	public Company findCompanyById(Long id);
	

	public Company deleteCompanyById(Long id);
	

	public Company createCompany(Company comp);
	

	public Company updateCompany(Company comp);
	
	public Job createJob(Long compId , Job job);
	
//	public List<Job> findAllJobs(Long companyId);
}
