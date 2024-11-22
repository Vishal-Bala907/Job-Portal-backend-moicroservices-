package com.vb.job.dto.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
public class JobDTO {
	private Long id;
	private String title;
	private String description; 
	private long maxSalary;
	private long minSalary;
	private String location;
	private CompanyDTO company;
}
