package com.vb.ms.company.modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Review {
	private Long reviewId;
	private String description;
	private double rating;
	
	private Long compId;
}
