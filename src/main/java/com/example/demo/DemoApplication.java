package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.Student.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //makes this class serve rest end points
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping //states this function is a get request
	public List<Student> hello(){
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
