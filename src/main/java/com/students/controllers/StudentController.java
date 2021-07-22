package com.students.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.models.Student;
import com.students.services.StudentService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentService student;
	
	@GetMapping("students/")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = student.findAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@GetMapping("students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		Student s = student.findStudentById(id);
		return new ResponseEntity<>(s, HttpStatus.OK);		
	}
	
	@PostMapping("add/")
	public ResponseEntity<Student> addStudent(@RequestBody Student s){
		Student newStudent = student.createStudent(s);
		return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
		
	}
	
	@PutMapping("edit/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable("id") Long id, @RequestBody Student s){
		Student newStudent = student.findStudentById(id);
		newStudent.setAge(s.getAge());
		newStudent.seteCode(s.geteCode());
		newStudent.setEmail(s.getEmail());
		newStudent.setFirstName(s.getFirstName());
		newStudent.setLastName(s.getLastName());
		newStudent.setLevel(s.getLevel());
		newStudent.setImageUrl(s.getImageUrl());
;		student.updateStudent(newStudent);
		return new ResponseEntity<>(newStudent, HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
		student.deleteStudentById(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
	
	
}
