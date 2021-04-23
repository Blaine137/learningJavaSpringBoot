package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //marks StudentService as a service and gives the access to be injected/autowired 
public class StudentService {
    
    public List<Student> getStudents(){
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
