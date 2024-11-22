package com.vb.ms.company.modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString
public class Job {
	private Long id;
	private String title;
	private String description; 
	private long maxSalary;
	private long minSalary;
	private String location;
	private Long compId;
}
