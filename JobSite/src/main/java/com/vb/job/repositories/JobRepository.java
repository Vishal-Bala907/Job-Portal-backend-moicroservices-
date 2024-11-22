package com.vb.job.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.job.modals.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
