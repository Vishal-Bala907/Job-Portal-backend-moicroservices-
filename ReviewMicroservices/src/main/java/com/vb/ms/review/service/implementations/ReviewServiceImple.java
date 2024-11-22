package com.vb.ms.review.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.ms.review.modals.Review;
import com.vb.ms.review.repos.ReviewRepo;
import com.vb.ms.review.service.interfaces.ReviewService;

@Service
public class ReviewServiceImple implements ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Override
	public String createReview(Long compId , Review review) {
//		Company company = companyService.findCompanyById(compId);
//		if(company == null) {
//			return null;
//		}
//		company.getReviews().add(review);
//		review.setCompany(company);
//		companyService.createCompany(company);
		review.setCompId(compId);
		reviewRepo.save(review);
		return "Review added...";
	}

	public String deleteReview(Long rId) {
		Optional<Review> byId = reviewRepo.findById(rId);
		
		if(byId.isPresent()) {
			reviewRepo.delete(byId.get());
			return "Rating deleted...";
		}
		
		return null;
	}

	public List<Review> getReviewsByCompId(Long compId) {
		List<Review> list = reviewRepo.findByCompId(compId);
		return list;
	}

}
