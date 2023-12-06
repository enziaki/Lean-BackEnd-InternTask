package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

import java.util.List;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
   
     @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/mentor/{mentorId}")
    public ResponseEntity<List<Review>> getReviewsByMentorId(@PathVariable Long mentorId) {
        List<Review> reviews = reviewService.getReviewsByMentorId(mentorId);
        return ResponseEntity.ok(reviews);
    }
    
    @PostMapping("/submit")
    public ResponseEntity<String> submitReview(@RequestBody Review newReview) {
        reviewService.saveReview(newReview);
        return ResponseEntity.ok("Review submitted successfully");
    }
}
