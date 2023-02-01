package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
public interface ValidationRepository extends JpaRepository<User, Integer> {

}
