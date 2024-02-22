package com.example.service;

import java.util.List;

import com.example.responce.entity.StudentResponce;

public interface StudentService {
	
	public StudentResponce saveStudent(StudentResponce studentResponce);
	
	public List<StudentResponce> getAllStudent();

	public StudentResponce getStudentById(int id);
	
	public StudentResponce updateStudent(StudentResponce studentResponce, int id);
	
	public void deleteStudentById(int id);
	
	
}
