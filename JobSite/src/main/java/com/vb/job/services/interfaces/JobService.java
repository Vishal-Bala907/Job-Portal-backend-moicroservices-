package com.vb.job.services.interfaces;

import java.util.List;

import com.vb.job.dto.data.JobDTO;
import com.vb.job.modals.Job;

public interface JobService {
	
	public List<JobDTO> findAllJobs();

	
	public Job findJobById(Long id);
	

	public Job deleteJobById(Long id);
	

	public Job createJob(Job job, Long compId);
	

	public Job updateJob(Job job);
}
