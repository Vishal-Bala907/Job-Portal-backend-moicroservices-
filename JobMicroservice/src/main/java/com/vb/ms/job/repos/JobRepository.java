package com.vb.ms.job.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.ms.job.modals.Job;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	
	List<Job> findByCompId(Long id);
	
}
