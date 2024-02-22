package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.StudentRepository;
import com.example.entity.Student;
import com.example.responce.entity.StudentResponce;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentResponce saveStudent(StudentResponce studentResponce) {

		Student student = this.modelMapper.map(studentResponce, Student.class);
		Student student2 = this.studentRepository.save(student);
		StudentResponce studentResponce2 = this.modelMapper.map(student2, StudentResponce.class);
		return studentResponce2;
	}

	@Override
	public List<StudentResponce> getAllStudent() {
		List<Student> students = this.studentRepository.findAll();
		List<StudentResponce> studentResponses = students.stream()
				.map(student -> modelMapper.map(student, StudentResponce.class)).collect(Collectors.toList());

		return studentResponses;
	}

	@Override
	public StudentResponce getStudentById(int id) {

		Student student = this.studentRepository.findById(id).get();
		StudentResponce studentResponce = this.modelMapper.map(student, StudentResponce.class);

		return studentResponce;
	}

	@Override
	public StudentResponce updateStudent(StudentResponce studentResponce, int id) {

		Student student = this.studentRepository.findById(id).get();

		student.setName(studentResponce.getName());
		student.setAddress(studentResponce.getAddress());
		student.setAge(studentResponce.getAge());
		student.setEmail(studentResponce.getEmail());
		student.setPhone(studentResponce.getPhone());

		Student student2 = this.studentRepository.save(student);
		StudentResponce studentResponce2 = this.modelMapper.map(student2, StudentResponce.class);
		return studentResponce2;
	}

	@Override
	public void deleteStudentById(int id) {

		this.studentRepository.deleteById(id);

	}

}