package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Student;


public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(long id);
	Student updateStudent(Student student);
	void deleteStudentById(long id);
}
