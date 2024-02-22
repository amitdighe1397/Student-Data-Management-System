package com.example.responce.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class StudentResponce {

	
	private int studentId;


	@NotEmpty
	@Size(min = 10,max = 20,message = "maxi char 4 and maxi 8 !!")
	private String name;

	@Email(message = "Email Address Not Valid !!")
	private String email;

	@NotEmpty
	@Size(min = 15, max = 20)
	private String address;

	private int age;

	@NotEmpty
	@Size(min = 10, max = 10)
	private String phone;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
