package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;
 
public interface UserRepository extends CrudRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.email = :email")
    //public User getUserByUsername(@Param("username") String username);
	public User getUserByEmail(@Param("email")String username);

	public User save(org.springframework.security.core.userdetails.User user);

	
}
