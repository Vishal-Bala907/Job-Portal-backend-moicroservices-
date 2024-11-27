package com.vb.ms.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ReviewMessageDTO {
	private Long reviewId;
	private String description;
	private double rating;
	private Long compId;
}
