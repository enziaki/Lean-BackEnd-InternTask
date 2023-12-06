package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "students")

@Getter
@Setter
@ToString

public class Student {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String username;
    private String email;
    private String password;
    private String bio;

    @OneToMany(mappedBy = "student")
    private List<Review> review;

}
