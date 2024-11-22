package com.vb.job.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vb.job.dto.data.CompanyDTO;
import com.vb.job.dto.data.JobDTO;
import com.vb.job.dto.data.ReviewDTO;
import com.vb.job.modals.Company;
import com.vb.job.modals.Job;
import com.vb.job.modals.Review;
import com.vb.job.repositories.JobRepository;
import com.vb.job.services.interfaces.DTOInterface;

@Component
public class DTOimplementation implements DTOInterface {
	@Autowired
	JobRepository jobRepository;
	@Autowired
	private CompanyServiceImplementation company;

	@Override
	public List<JobDTO> findAllJobs() {
		List<Job> jobs = jobRepository.findAll(); // contains recursive calls
		// sanitize data
		ArrayList<JobDTO> collect = jobs.stream().map(job->{
			Company company = job.getCompany();
			CompanyDTO companyDTO = CompanyDTO.builder()
				.id(company.getId())
				.companyName(company.getCompanyName())
				.description(company.getDescription())
				.build();
			
			
			return JobDTO.builder()
					.id(job.getId())
					.title(job.getTitle())
					.description(job.getDescription())
					.maxSalary(job.getMaxSalary())
					.minSalary(job.getMinSalary())
					.location(job.getLocation())
					.company(companyDTO)			
			.build();
		}).collect(Collectors.toCollection(ArrayList::new));
		return collect;
	}
	
	public List<ReviewDTO> findReviewsByCompanyId(Long compId) {
		Company companyByID = company.findCompanyById(compId);
		if(companyByID == null) {
			return null;
		}
		List<Review> reviews = companyByID.getReviews();
		ArrayList<ReviewDTO> collect = reviews.stream().map(r->{
			return ReviewDTO.builder()
					.reviewId(r.getReviewId())
					.description(r.getDescription())
					.rating(r.getRating())
					.build();
		}).collect(Collectors.toCollection(ArrayList::new));
		
		return collect;
	}
	

	@Override
	public JobDTO findJobById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyDTO> findAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}



}
