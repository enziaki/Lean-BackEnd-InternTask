package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.services.RecommendStudentService;
import com.example.demo.entities.RecommendStudent;

@RestController
@RequestMapping("/api/recommend")
public class RecommendStudentController {
    
    @Autowired
    private RecommendStudentService recommendStudentService;

    // get all of the recommendations
    @GetMapping
    public ResponseEntity<List<RecommendStudent>> getAllRecommendations(){
        List<RecommendStudent> recommendation = recommendStudentService.getAllRecommendations();
        return ResponseEntity.ok(recommendation);
    }

    // get recommendation by id
    @GetMapping("/{id}")
    public ResponseEntity<RecommendStudent> getRecommendationById(@PathVariable long id){
        RecommendStudent recommendation = recommendStudentService.getRecommendationById(id);
        if (recommendation != null) {
            return ResponseEntity.ok(recommendation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new resource
    @PostMapping
    public ResponseEntity<RecommendStudent> saveRecommendation(@RequestBody RecommendStudent recommendation) {
        RecommendStudent savedRecommendation = recommendStudentService.saveRecommendation(recommendation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecommendation);
    }

    
    // update a new resource
    @PutMapping("/{id}")
    public ResponseEntity<RecommendStudent> updateRecommendation(@PathVariable Long id, @RequestBody RecommendStudent recommendation) {
        RecommendStudent existingRecommendation = recommendStudentService.getRecommendationById(id);
        if (existingRecommendation != null) {
            recommendation.setId(id);
            RecommendStudent updatedRecommendation = recommendStudentService.updateRecommendation(recommendation);
            return ResponseEntity.ok(updatedRecommendation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete a recommendation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
        RecommendStudent existingRecommendation = recommendStudentService.getRecommendationById(id);
        if (existingRecommendation != null) {
            recommendStudentService.deleteRecommendation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
