package com.example.demo.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInit {

    public static void dbInit() throws Exception{
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:file:~/repos/syncbs/Lean-BE-InternTask;MODE=FILE", "sa", "");
        Statement stmt = conn.createStatement();

        //create user table
        stmt.executeUpdate("CREATE TABLE students (id INT PRIMARY KEY, username VARCHAR(255), email VARCHAR(255), password VARCHAR(255), bio TEXT");

        //create mentors table
        stmt.executeUpdate("CREATE TABLE mentors (id INT PRIMARY KEY, name VARCHAR(255), bio TEXT, overallRating DECIMAL(2,1)");

        //create reviews table
        stmt.executeUpdate("CREATE TABLE reviews (id INT PRIMARY KEY, user_id INT, mentor_id INT, rating INT, reviewText TEXT, FOREIGN KEY (user_id) REFERENCES students(id), FOREIGN KEY (mentor_id) REFERENCES mentors(id))");

        //create RecommendStudent table
        stmt.executeUpdate("CREATE TABLE recommend_students (id INT PRIMARY KEY, mentor_id INT, studentName VARCHAR(255), studentBio TEXT, recommendationText TEXT, recommendationLink VARCHAR(255), FOREIGN KEY (mentor_id) REFERENCES mentors(id))");

        conn.close();
    }
    
}
