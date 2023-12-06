package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RecommendStudentRepo;
import com.example.demo.entities.RecommendStudent;

@Service
public class RecommendStudentService {
    
    @Autowired
    private RecommendStudentRepo recommendStudentRepo;

    public List<RecommendStudent> getAllRecommendations() {
        return recommendStudentRepo.findAll();
    }

    public RecommendStudent getRecommendationById(Long id) {
        return recommendStudentRepo.findById(id).orElse(null);
    }

    public RecommendStudent saveRecommendation(RecommendStudent recommendation) {
        return recommendStudentRepo.save(recommendation);
    }

    public RecommendStudent updateRecommendation(RecommendStudent recommendation) {
        // Ensure the recommendation to be updated already exists in the database
        if (recommendStudentRepo.existsById(recommendation.getId())) {
            return recommendStudentRepo.save(recommendation);
        } else {
            return null;
        }
    }

    public void deleteRecommendation(Long id) {
        recommendStudentRepo.deleteById(id);
    }
}
