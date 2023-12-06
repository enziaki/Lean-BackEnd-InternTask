package com.example.demo.controllers;

import java.util.Optional;
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

import com.example.demo.entities.Review;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.services.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
   
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    private ReviewService reviewService;

    // Get all of the students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        try{
            List<Student>  list = studentRepo.findAll();

            if(list.isEmpty() || list.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Optional<Student> student = studentRepo.findById(id);

        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Enter student details
    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update the student entry
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        
        try{
            return new ResponseEntity<>(studentRepo.save(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete student by id
    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id){

        try{
            Optional<Student> student = studentRepo.findById(id);
            if(student.isPresent()){
                studentRepo.delete(student.get());
            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // submit reviews
    @PostMapping("/submit-review")
    public ResponseEntity<String> submitReview(@RequestBody Review newReview){
    reviewService.saveReview(newReview);
    return ResponseEntity.ok("Accepted");
    }
}

