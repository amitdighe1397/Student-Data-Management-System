package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.responce.entity.StudentResponce;
import com.example.service.StudentService;

@RestController
@RequestMapping("/Student-api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<StudentResponce> saveStudent(@Validated @RequestBody StudentResponce studentResponce) {

		StudentResponce studentResponce2 = this.studentService.saveStudent(studentResponce);

		return new ResponseEntity<StudentResponce>(studentResponce2, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<StudentResponce>> getAllStudent() {

		List<StudentResponce> list = this.studentService.getAllStudent();

		return new ResponseEntity<List<StudentResponce>>(list, HttpStatus.FOUND);

	}

	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<StudentResponce> getStudentById(@PathVariable int id) {

		StudentResponce studentResponce = this.studentService.getStudentById(id);

		return new ResponseEntity<StudentResponce>(studentResponce, HttpStatus.FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentResponce> updateStudent(@RequestBody StudentResponce studentResponce, @PathVariable int id) {

		
		StudentResponce studentResponce2 = this.studentService.updateStudent(studentResponce, id);

		return new ResponseEntity<StudentResponce>(studentResponce2, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable int id) {

		this.studentService.deleteStudentById(id);
		return "Data Deleted";

	}

}
