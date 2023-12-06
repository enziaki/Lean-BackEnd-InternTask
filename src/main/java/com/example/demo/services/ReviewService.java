package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MentorRepo;
import com.example.demo.repository.ReviewRepo;
import com.example.demo.entities.Review;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    
    @Autowired
    private MentorRepo mentorRepo;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public List<Review> getReviewsByMentorId(Long mentorId) {
        return reviewRepo.findByMentorId(mentorId);
    }

    public void saveReview(Review review) {
        // Ensure that the student is submitting a review for a valid mentor
            reviewRepo.save(review);
    }

    
}
