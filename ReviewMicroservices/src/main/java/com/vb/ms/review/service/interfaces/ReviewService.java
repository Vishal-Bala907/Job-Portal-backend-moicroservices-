package com.vb.ms.review.service.interfaces;

import java.util.List;

import com.vb.ms.review.modals.Review;

public interface ReviewService {
	String createReview(Long compId, Review review);

	String deleteReview(Long rId);
	
	public List<Review> getReviewsByCompId(Long compId);
}
