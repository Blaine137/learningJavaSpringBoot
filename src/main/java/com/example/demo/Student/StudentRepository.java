package com.example.demo.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

    // <> specifies the type the repository should work with and id type
@Repository //states that this interface is a repo
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email); // performs SELECT * from Student where email === student.email
    
}
