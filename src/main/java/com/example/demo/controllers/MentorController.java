package com.example.demo.controllers;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Mentor;
import com.example.demo.repository.MentorRepo;

@RestController
@RequestMapping("/api")
public class MentorController {
    
    @Autowired
    MentorRepo mentorRepo;

    // Get all of the mentors
    @GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> getAllMentors(){
        try{
            List<Mentor> list = mentorRepo.findAll();

            if(list.isEmpty() || list.size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

            return new ResponseEntity<>(list, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get a single mentor by id
    @GetMapping("/mentors/{id}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Long id){
        Optional<Mentor> mentor = mentorRepo.findById(id);

        if(mentor.isPresent()){
            return new ResponseEntity<>(mentor.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // get mentor by his/her Rating
    @GetMapping("/ratings/{rating}")
    public ResponseEntity<List<Mentor>> getMentorsByRatings(@PathVariable int rating){
        List<Mentor> mentors = mentorRepo.findByOverallRating(rating);

        return ResponseEntity.ok(mentors);
    }

    // add mentor
    @PostMapping("/mentors")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor) {
        try {
            Mentor savedMentor = mentorRepo.save(mentor);
            return new ResponseEntity<>(savedMentor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
