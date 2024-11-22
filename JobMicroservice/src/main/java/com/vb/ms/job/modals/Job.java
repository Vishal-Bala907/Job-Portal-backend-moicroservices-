package com.vb.ms.job.modals;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity(name="job")
public class Job {
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private String description; 
	private long maxSalary;
	private long minSalary;
	private String location;

	@Column(name = "company_id")
	private Long compId;
}
