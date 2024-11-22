package com.vb.job.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	
	@JsonIgnore
	@ManyToOne
	private Company company;
}
