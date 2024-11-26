package com.vb.ms.company.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.ms.company.dto.CompanyDTO;
import com.vb.ms.company.feign.JobFeign;
import com.vb.ms.company.feign.ReviewFeign;
import com.vb.ms.company.modals.Company;
import com.vb.ms.company.modals.Job;
import com.vb.ms.company.modals.Review;
import com.vb.ms.company.repos.CompanyRepository;
import com.vb.ms.company.services.interfaces.CompanyService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private JobFeign jobFeign;
	@Autowired
	private ReviewFeign reviewFeign;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImplementation.class);

	@CircuitBreaker(name="companyBreaker" , fallbackMethod = "findAllFallBack")
	@Override
	public List<CompanyDTO> findAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		
		
		ArrayList<CompanyDTO> collect = companies.stream().map(comp->{
			List<Job> jobs = jobFeign.findJobByCompanyId(comp.getId()).getBody();
			List<Review> review = reviewFeign.getAllReviewOfCompany(comp.getId()).getBody();
		  return CompanyDTO.builder()
			.id(comp.getId())
			.companyName(comp.getCompanyName())
			.description(comp.getDescription())
			.jobs(jobs)
			.reviews(review)
			.build();
		}).collect(Collectors.toCollection(ArrayList::new));
		
		
		return collect;
	}
	
	public List<CompanyDTO> findAllFallBack(Exception ex) {
		LOGGER.warn("FALL-BACK {}" + ex.getMessage());
		return List.of( CompanyDTO.builder()
				.id(0l)
				.companyName("fall-back company")
				.description("fallback description")
				.jobs(null)
				.reviews(null)
				.build() );
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
	}

	@Override
	public Job createJob(Long compId, Job job) {
		Job job2 = jobFeign.createJob(job, compId).getBody();
		return job2;
	}
}
