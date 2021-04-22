package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //makes this class serve rest end points
@RequestMapping(path = "api/v1/student") //get request endpoint
public class StudentController {
   
   
    @GetMapping //states this function is called for a get request ("api/v1/students")
	public List<Student> getStudent(){
		return List.of(
			new Student(
				1L,
				"Blaine",
				"blaine@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		); //creates a list of a student
	}
}
