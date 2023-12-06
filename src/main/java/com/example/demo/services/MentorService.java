package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entities.Mentor;
import com.example.demo.entities.Review;
import com.example.demo.repository.MentorRepo;

@Service
public class MentorService {
    
    @Autowired
    private MentorRepo mentorRepo;

    public void updateOverallRating(Mentor mentor){
        
        List<Review> reviews = mentor.getReview();
        if(reviews != null && !reviews.isEmpty()){
            double meanRating = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
            
            meanRating = Math.max(1.0, Math.min(5.0, meanRating));
            mentor.setOverallRating((int) meanRating);
            mentorRepo.save(mentor);
        }
    }
}
