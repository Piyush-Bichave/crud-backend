package com.piyush.crud.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.piyush.crud.entity.Student;
import com.piyush.crud.repository.StudentRepository;

@CrossOrigin(origins = "https://piyush-crud-app.netlify.app/")
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		List<Student> student =  repo.findAll();
		return student;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		return student;
	}
	
	@PostMapping("/student/add")
	public String addStudent(@RequestBody Student student) {
		repo.save(student);
		return "Student Created Sucessfully";
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student updatedStudent) {
		Student student = repo.findById(id).get();
		
		student.setName(updatedStudent.getName());
		student.setPercentage(updatedStudent.getPercentage());
		student.setBranch(updatedStudent.getBranch());
		
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		Optional<Student> student = repo.findById(id);
		
		if(student.isPresent()) {
			repo.delete(student.get());
			return "Student deleted sucessfully";
		} else {
			return "student not found";
		}
	}

}
