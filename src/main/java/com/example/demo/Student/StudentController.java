package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //makes this class serve rest end points
@RequestMapping(path = "api/v1/student") //get request endpoint
public class StudentController {

	private final StudentService studentService;

	@Autowired //finds StudentService and injects it into this function
	public StudentController(StudentService studentService){
		this.studentService = studentService;
	}
   
    @GetMapping //states this function is called for a get request ("api/v1/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

	@PostMapping //states this function is a post request
	public void registerNewStudent(@RequestBody Student student){
		studentService.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}") //states this is a delete method deleting the student by its ID
	public void deleteStudent(@PathVariable("studentId") Long studentId){
		studentService.deleteStudent(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email){
				
		studentService.updateStudent(studentId, name, email);

	}
}
