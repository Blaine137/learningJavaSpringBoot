package com.example.demo.Student;

import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
		.findStudentByEmail(student.getEmail()); //looks to see if the email is already taken

		if(studentOptional.isPresent()){
			throw new IllegalStateException("email is taken"); //throw error if email exists
		}
		studentRepository.save(student); //if email does not exist then save it to the database
		System.out.println(student);
    }

}
