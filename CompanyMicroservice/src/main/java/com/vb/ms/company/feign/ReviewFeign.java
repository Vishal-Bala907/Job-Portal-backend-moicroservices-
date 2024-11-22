package com.vb.ms.company.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vb.ms.company.modals.Review;

//import com.vb.ms.review.modals.Review;

@FeignClient("REVIEWMICROSERVICES")
public interface ReviewFeign {
	@PostMapping("/review/{compId}/create")
	public ResponseEntity<String> createReview(@PathVariable Long compId ,@RequestBody Review review);
	
	@GetMapping("/review/all/{compId}")
	public ResponseEntity<List<Review>> getAllReviewOfCompany(@PathVariable Long compId);
	
	@DeleteMapping("/review/del/{rId}") 
	public ResponseEntity<String> deleteReview(@PathVariable Long rId);
	
	@GetMapping("/review/comp/{id}")
	public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long id);
}
