package com.students.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.exceptions.ResourcesNotFoundException;
import com.students.models.Student;
import com.students.repository.IStudentRepository;

@Service 
public class StudentService {
	@Autowired
	private IStudentRepository srepo;
	
	
	public List<Student> findAllStudents() {
		return srepo.findAll();
	}
	
	public Student findStudentById(Long id) {
		if(srepo.findById(id).isPresent()) {
			return srepo.getById(id);
		}else {
			throw new ResourcesNotFoundException("Ressource indisponible");
		}
		
	}
	
	public Student createStudent(Student student) {
		student.seteCode(UUID.randomUUID().toString());
		return srepo.save(student);
	}
	
	public Student updateStudent(Student student) {
		if(srepo.findById(student.getId()).isPresent()) {
			return srepo.save(student);
		} else {
			throw new ResourcesNotFoundException("Ressource indisponible");
		}
		
	}
	
	public void deleteStudentById(Long id) {
		if (srepo.findById(id).isPresent()) {
			srepo.deleteById(id);
		} else {
			throw new ResourcesNotFoundException("Ressource indisponible");
		}
	}
	
	
}
