package com.vb.job.modals;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Job> jobs;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Review> reviews;
	
}
