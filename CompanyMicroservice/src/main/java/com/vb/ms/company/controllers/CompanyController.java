package com.vb.ms.company.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.vb.ms.company.dto.CompanyDTO;
import com.vb.ms.company.modals.Company;
import com.vb.ms.company.modals.Job;
import com.vb.ms.company.services.implementations.CompanyServiceImplementation;


@RestController
@RequestMapping("/comp")
public class CompanyController {
	
	@Autowired
	private CompanyServiceImplementation companyService;
	
	@GetMapping("/all") 
	public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
		List<CompanyDTO> allCompanies = companyService.findAllCompanies();
		return allCompanies.size() == 0 ? 
			new ResponseEntity<>(null , HttpStatus.NOT_FOUND) :
				new ResponseEntity<>(allCompanies , HttpStatus.OK);
	}
	
	@PutMapping("/upd")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		Company updateCompany = companyService.updateCompany(company);
		return updateCompany == null ? 
				new ResponseEntity<>(null , HttpStatus.NOT_FOUND) :
					new ResponseEntity<>(updateCompany , HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		Company created = 	companyService.createCompany(company);
		return ResponseEntity.ok(created);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		Company created = 	companyService.deleteCompanyById(id);
		return created == null ? 
				new ResponseEntity<>("Company Not Found" , HttpStatus.NOT_FOUND) :
					new ResponseEntity<>("Company deleted" , HttpStatus.OK);
	}
	
	
	@PostMapping("/create/job/{compid}")
	public ResponseEntity<Job> createJob(@PathVariable Long compid ,  @RequestBody Job job)
	{
		Job job2 = companyService.createJob(compid, job);
		return job2 == null ? 
				new ResponseEntity<>(null , HttpStatus.NOT_FOUND) :
					new ResponseEntity<>(job2, HttpStatus.OK);
	}
	
}
