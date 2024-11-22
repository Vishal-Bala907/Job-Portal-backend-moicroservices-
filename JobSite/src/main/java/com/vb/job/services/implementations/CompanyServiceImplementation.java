package com.vb.job.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.job.modals.Company;
import com.vb.job.modals.Job;
import com.vb.job.repositories.CompanyRepository;
import com.vb.job.services.interfaces.CompanyService;

@Service
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> findAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company findCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public Company deleteCompanyById(Long id) {
		return companyRepository.findById(id).map(com -> {
			companyRepository.delete(com);
			return com;
		}).orElse(null);
	}

	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
	  return companyRepository.findById(company.getId()).map(c->{
			c.setCompanyName(company.getCompanyName());
			c.setDescription(c.getDescription());
			return companyRepository.save(c);
		}).orElse(null);
//		return null;
	}

	@Override
	public List<Job> findAllJobs(Long companyId) {
		Optional<List<Job>> map = companyRepository.findById(companyId).map(com->{
			return com.getJobs();
		});
		
		return map.orElse(null);
	}

}
