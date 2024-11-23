package com.vb.ms.job.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vb.ms.job.modals.Job;
import com.vb.ms.job.services.implementations.JobServiceImplementation;
@RestController
@RequestMapping("/jbs")
public class JobController {

	@Autowired
	private JobServiceImplementation jobServiceImplementation;

	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAllJobs() {
		List<Job> allJobs = jobServiceImplementation.findAllJobs();
		return new ResponseEntity<>(allJobs, HttpStatus.OK);
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable Long id) {
		Job jobById = jobServiceImplementation.findJobById(id);
		if (jobById == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(jobById, HttpStatus.OK);
		}
	}

	@DeleteMapping("/jobs-del/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id) {

		Job deleteJobById = jobServiceImplementation.deleteJobById(id);
		if (deleteJobById == null) {
			return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Job deleted...", HttpStatus.OK);
		}
	}

	@PostMapping("/create-job")
	public  ResponseEntity<Job>  createJob(@RequestBody Job job , 
			@RequestParam Long compId
			) {
		return new ResponseEntity<>(jobServiceImplementation.createJob(job, compId), HttpStatus.CREATED);
	}

	@PutMapping("/update-job")
	public  ResponseEntity<Job> updateJob(@RequestBody Job job) {
		Job updateJob = jobServiceImplementation.updateJob(job);
		if (updateJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(updateJob, HttpStatus.OK);
		}
	}
	
	@GetMapping("/jobs/comp/{id}")
	public ResponseEntity<List<Job>> findJobByCompanyId(@PathVariable Long id) {
		return new ResponseEntity<>(jobServiceImplementation.findJobByCompId(id),HttpStatus.OK);
	}

}
