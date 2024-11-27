package com.vb.ms.company.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.vb.ms.company.dto.ReviewMessageDTO;
import com.vb.ms.company.modals.Company;
import com.vb.ms.company.services.implementations.CompanyServiceImplementation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReviewMessageConsumer {
	private final CompanyServiceImplementation company;
	
	
	@RabbitListener(queues = "companyRatingQueue")
	public void consumeMessasge(ReviewMessageDTO dto) {
		
		Company companyById = company.findCompanyById(dto.getCompId());
		System.out.println(dto);
		System.out.println("Jai shree ram {}{}{}");
//		company.createCompany(companyById);
	}
	
}
