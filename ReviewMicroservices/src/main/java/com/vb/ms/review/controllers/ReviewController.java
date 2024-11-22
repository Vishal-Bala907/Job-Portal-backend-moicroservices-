package com.vb.ms.review.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vb.ms.review.modals.Review;
import com.vb.ms.review.service.implementations.ReviewServiceImple;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImple reviewService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createReview(@RequestParam Long compId ,@RequestBody Review review) {
		
//		System.out.println("Hello everyone");
		String review2 = reviewService.createReview(compId, review);
		return review2 == null ?
				ResponseEntity.notFound().build() : 
					ResponseEntity.ok(review2);
	}
	
	@GetMapping("/all/{compId}")
	public ResponseEntity<List<Review>> getAllReviewOfCompany(@PathVariable Long compId) {
		List<Review> reviews =  reviewService.getReviewsByCompId(compId);
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
	
	@GetMapping("/comp/{id}")
	public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long id) {
		List<Review> reviewsByCompId = reviewService.getReviewsByCompId(id);
		return new ResponseEntity<>(reviewsByCompId , HttpStatus.OK);
	}
	
}
