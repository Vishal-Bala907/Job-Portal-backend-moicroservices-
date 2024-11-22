package com.vb.job.services.interfaces;

import java.util.List;

import com.vb.job.modals.Company;
import com.vb.job.modals.Job;

public interface CompanyService {
	
	public List<Company> findAllCompanies();

	
	public Company findCompanyById(Long id);
	

	public Company deleteCompanyById(Long id);
	

	public Company createCompany(Company job);
	

	public Company updateCompany(Company job);
	
	public List<Job> findAllJobs(Long companyId);
}
