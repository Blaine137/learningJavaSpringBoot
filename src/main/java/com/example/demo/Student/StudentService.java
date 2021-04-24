package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marks StudentService as a service and gives the access to be injected/autowired 
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
    
    public List<Student> getStudents(){
		return studentRepository.findAll(); //returns a list of students
	}

}
