package com.vb.job.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.job.dto.data.ReviewDTO;
import com.vb.job.modals.Company;
import com.vb.job.modals.Review;
import com.vb.job.repositories.ReviewRepo;
import com.vb.job.services.interfaces.ReviewService;

@Service
public class ReviewServiceImple implements ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;
	@Autowired
	private CompanyServiceImplementation companyService;
	@Autowired
	private DTOimplementation dto;
	
	@Override
	public String createReview(Long compId , Review review) {
		Company company = companyService.findCompanyById(compId);
		if(company == null) {
			return null;
		}
		company.getReviews().add(review);
		review.setCompany(company);
		companyService.createCompany(company);
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

	public List<ReviewDTO> getAllReviewOfCompany(Long compId) {
		List<ReviewDTO> list = dto.findReviewsByCompanyId(compId);
		return list;
	}

}
