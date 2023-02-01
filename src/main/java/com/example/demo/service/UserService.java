package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.User;



public interface UserService extends UserDetailsService{
	public User save(User user);

	void updateUser(User existingUser);

	User save(UserRegistrationDto registrationDto);
}