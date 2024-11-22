package com.vb.ms.job.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.ms.job.modals.Job;
import com.vb.ms.job.repos.JobRepository;
import com.vb.ms.job.services.interfaces.JobService;

@Service
public class JobServiceImplementation implements JobService {

//	private List<Job> jobs = new ArrayList<>();
//	private Long lng = 1L;

	@Autowired
	private JobRepository jobRepository;
//	@Autowired
//	private CompanyServiceImplementation companyService;
//	@Autowired
//	DTOimplementation dto;

	@Override
	public List<Job> findAllJobs() {
		List<Job> allJobs = jobRepository.findAll();
		return allJobs;
	}

	@Override
	public Job findJobById(Long id) {
		Optional<Job> byId = jobRepository.findById(id);
		return byId.orElse(null);
//		return null;
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

		job.setCompId(compId);
		Job save = jobRepository.save(job);

		return save;
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

	@Override
	public List<Job> findJobByCompId(Long compId) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		return jobRepository.findByCompId(compId);
	}

}
