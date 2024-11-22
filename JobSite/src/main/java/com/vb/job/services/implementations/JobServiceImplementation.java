package com.vb.job.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.job.dto.data.JobDTO;
import com.vb.job.modals.Company;
import com.vb.job.modals.Job;
import com.vb.job.repositories.JobRepository;
import com.vb.job.services.interfaces.JobService;

@Service
public class JobServiceImplementation implements JobService {

//	private List<Job> jobs = new ArrayList<>();
//	private Long lng = 1L;

	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private CompanyServiceImplementation companyService;
	@Autowired
	DTOimplementation dto;

	@Override
	public List<JobDTO> findAllJobs() {
		List<JobDTO> allJobs = dto.findAllJobs();
		return allJobs;
	}

	@Override
	public Job findJobById(Long id) {
		Optional<Job> byId = jobRepository.findById(id);
		return byId.orElse(null);
	}

	@Override
	public Job deleteJobById(Long id) {

		return jobRepository.findById(id).map(job -> {
			jobRepository.delete(job);
			return job;
		}).orElse(null);
	}

	@Override
	public Job createJob(Job job, Long compId) {
		Company companyById = companyService.findCompanyById(compId);
		
		if(companyById == null) {
			return null;
		}
		
		job.setCompany(companyById);
		companyById.getJobs().add(job);
		
		companyService.createCompany(companyById);
		return job;
	}

	@Override
	public Job updateJob(Job job) {

		return jobRepository.findById(job.getId()).map(j -> {
			j.setTitle(job.getTitle());
			j.setDescription(job.getDescription());
			j.setMaxSalary(job.getMaxSalary());
			j.setMinSalary(job.getMinSalary());
			j.setLocation(job.getLocation());
			jobRepository.save(job);
			return j;
		}).orElse(null);
	}

}
