package com.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
