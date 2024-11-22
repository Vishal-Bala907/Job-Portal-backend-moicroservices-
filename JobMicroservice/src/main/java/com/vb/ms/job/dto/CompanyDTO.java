package com.vb.ms.job.dto;

import java.util.List;

import com.vb.ms.job.modals.Job;

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
public class CompanyDTO {
	private Long id;
	private String companyName;
	private String description;
	
	private List<Job> jobs;
}
