package com.vb.ms.company.modals;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="company")
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class Company {
	
	@Id
	@Column(name="comp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String companyName;
	private String description;
	
	@ElementCollection
	private List<Long> jobId;

	@ElementCollection
	private List<Long> reviewsId;
	
}
