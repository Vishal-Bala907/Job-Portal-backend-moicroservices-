package com.vb.ms.review.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vb.ms.review.modals.Review;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
	List<Review> findByCompId(Long id);
}
