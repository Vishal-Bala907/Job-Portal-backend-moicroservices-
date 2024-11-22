package com.vb.ms.company.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.ms.company.modals.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
