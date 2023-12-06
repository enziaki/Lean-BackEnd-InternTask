package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.entities.Mentor;

@Repository
public interface MentorRepo extends JpaRepository<Mentor, Long>{

    List<Mentor> findByOverallRating(int overallRating);
    
}
