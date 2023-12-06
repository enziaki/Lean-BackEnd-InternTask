package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.RecommendStudent;

@Repository
public interface RecommendStudentRepo extends JpaRepository<RecommendStudent, Long>{
    
}
