package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Validation;


public interface ValidationService {
	List<Validation> getAllValidations();
	Validation saveValidation(Validation student);
	Validation getValidationById(int id);
	void deleteValidationById(int id);
}
