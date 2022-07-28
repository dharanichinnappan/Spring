package com.dharani.Restful.Rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dharani.Restful.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void LoadData() {
		students = new ArrayList<Student>();
		students.add(new Student("Dharani", "chinnappan"));
		students.add(new Student("Dhivya", "chinnappan"));
		students.add(new Student("Praveen", "Dhuruv"));
	}

	@GetMapping("/students")
	public List<Student> getSudentsList() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student with Id " + studentId + "  is not found ");
		}
		return students.get(studentId);
	}

}
