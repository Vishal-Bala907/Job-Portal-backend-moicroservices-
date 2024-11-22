package com.vb.job.services.interfaces;

import java.util.List;

import com.vb.job.dto.data.CompanyDTO;
import com.vb.job.dto.data.JobDTO;
import com.vb.job.dto.data.ReviewDTO;

public interface DTOInterface {
	List<JobDTO> findAllJobs();

	JobDTO findJobById(Long id);

	List<CompanyDTO> findAllCompanies();

	List<ReviewDTO> findReviewsByCompanyId(Long compId);
}
