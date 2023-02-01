package com.example.demo.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;
//import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Long> {
	//Aissa Chbaba
	/*@Query("SELECT s FROM Student s WHERE "
			+ "CONCAT(s.id, s.firstName, s.lastName, s.departement.name)"
			+" LIKE %?1%")
	public List<Student> search(String keyword);
	
	
	@Query("select count(id) from Student ")
	public String StudentsNBR();
	
	
	@Query("SELECT s.departement.name as departement , COUNT(s.departement.name ) as nbDepartement FROM Student s  GROUP BY s.departement.name")
	public List<?> reportByDepartement();
	
	/*@Query("select first_name,last_name from student")
	public List<Student> findAll();*/
	
}
