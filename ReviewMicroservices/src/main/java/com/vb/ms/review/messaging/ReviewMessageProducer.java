package com.vb.ms.review.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.ms.review.dto.ReviewMessageDTO;
import com.vb.ms.review.modals.Review;

@Service
public class ReviewMessageProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendReviewMessage(Review review) {
		ReviewMessageDTO reviewMessageDTO = ReviewMessageDTO.builder()
			.reviewId(review.getReviewId())
			.compId(review.getCompId())
			.description(review.getDescription())
			.rating(review.getRating())
			.build();
		
		rabbitTemplate.convertAndSend("companyRatingQueue" , reviewMessageDTO);
	}
	
}
