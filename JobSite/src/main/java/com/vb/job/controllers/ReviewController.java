package com.vb.job.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vb.job.dto.data.ReviewDTO;
import com.vb.job.modals.Review;
import com.vb.job.services.implementations.ReviewServiceImple;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImple reviewService;
	
	@PostMapping("/{compId}/create")
	public ResponseEntity<String> createReview(@PathVariable Long compId ,@RequestBody Review review) {
		String review2 = reviewService.createReview(compId, review);
		return review2 == null ?
				ResponseEntity.notFound().build() : 
					ResponseEntity.ok(review2);
	}
	
	@GetMapping("/all/{compId}")
	public ResponseEntity<List<ReviewDTO>> getAllReviewOfCompany(@PathVariable Long compId) {
		List<ReviewDTO> reviews =  reviewService.getAllReviewOfCompany(compId);
		return reviews == null ?
				new ResponseEntity<>(null,HttpStatus.NOT_FOUND) : 
					new ResponseEntity<>(reviews,HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{rId}") 
	public ResponseEntity<String> deleteReview(@PathVariable Long rId) {
		String review2 = reviewService.deleteReview(rId);
		return review2 == null ?
				new ResponseEntity<>("Company not found...",HttpStatus.NOT_FOUND) : 
					new ResponseEntity<>(review2,HttpStatus.OK);
	}
	
	
}
