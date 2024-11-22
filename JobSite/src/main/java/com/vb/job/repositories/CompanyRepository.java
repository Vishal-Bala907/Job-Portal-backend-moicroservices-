package com.vb.job.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.job.modals.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
