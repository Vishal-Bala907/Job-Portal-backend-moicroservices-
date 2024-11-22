package com.vb.job.services.interfaces;

import java.util.List;

import com.vb.job.dto.data.ReviewDTO;
import com.vb.job.modals.Review;

public interface ReviewService {
	String createReview(Long compId, Review review);

	String deleteReview(Long rId);

	List<ReviewDTO> getAllReviewOfCompany(Long compId);
}
