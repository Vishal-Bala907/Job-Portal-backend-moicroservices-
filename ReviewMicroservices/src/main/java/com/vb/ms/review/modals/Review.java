package com.vb.ms.review.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long reviewId;
	private String description;
	private double rating;
	
	private Long compId;
}
