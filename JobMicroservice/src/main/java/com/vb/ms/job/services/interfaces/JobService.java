package com.vb.ms.job.services.interfaces;

import java.util.List;

import com.vb.ms.job.modals.Job;
 
public interface JobService {
	
	public List<Job> findAllJobs();

	
	public Job findJobById(Long id);
	

	public Job deleteJobById(Long id);
	

	public Job createJob(Job job, Long compId);
	

	public Job updateJob(Job job);
	
	public List<Job> findJobByCompId(Long compId);
}
