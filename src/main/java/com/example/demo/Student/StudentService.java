package com.example.demo.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

    public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId); //finds the student by ID which returns true/false

		if(!exists){
			throw new IllegalStateException("student with id " + studentId + " does not exists!"); //if studentID does not exists
		}

		studentRepository.deleteById(studentId); //delete student out of the database
    }

	@Transactional
    public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
		.orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists")); //if the student id cannot be found then throw a error

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
			//if name is not null and the length is greater than 0 and if the name matches the same name in the student object
			student.setName(name);
		}

		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
			//if email is not null and the length is greater than 0 and if the email matches the same email in the student object
			Optional<Student> studentOptional = studentRepository
			.findStudentByEmail(email); //search the student object for the same email

			if(studentOptional.isPresent()){
				throw new IllegalStateException("email is taken!");
			}
			student.setEmail(email);
		}
    }

}
