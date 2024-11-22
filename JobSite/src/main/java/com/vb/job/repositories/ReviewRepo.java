package com.vb.job.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.job.modals.Review;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

}
