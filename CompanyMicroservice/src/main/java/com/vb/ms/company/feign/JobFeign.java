package com.vb.ms.company.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vb.ms.company.modals.Job;

//import com.vb.ms.job.modals.Job;

//@Component
@FeignClient("JOBMICROSERVICE")
public interface JobFeign {
	
	@GetMapping("/jbs/jobs")
	public ResponseEntity<List<Job>> findAllJobs();

	@GetMapping("/jbs/jobs/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable Long id);

	@DeleteMapping("/jbs/jobs-del/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id);

	@PostMapping("/jbs/create-job/{comp_id}")
	public  ResponseEntity<Job>  createJob(@RequestBody Job job , 
			@PathVariable Long comp_id
			);

	@PutMapping("/jbs/update-job")
	public  ResponseEntity<Job> updateJob(@RequestBody Job job);
	
	@GetMapping("/jbs/jobs/comp/{id}")
	public ResponseEntity<List<Job>> findJobByCompanyId(@PathVariable Long id);
}
