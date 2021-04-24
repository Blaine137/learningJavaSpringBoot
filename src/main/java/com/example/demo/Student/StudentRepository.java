package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    // <> specifies the type the repository should work with and id type
@Repository //states that this interface is a repo
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
