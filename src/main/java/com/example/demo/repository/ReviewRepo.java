package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{

List<Review> findByMentorId(Long mentorId);
}
