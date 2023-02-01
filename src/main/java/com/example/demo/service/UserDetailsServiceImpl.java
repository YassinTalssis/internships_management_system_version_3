package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
 
public class UserDetailsServiceImpl implements UserDetailsService,UserService {
 
    @Autowired
    private UserRepository userRepository;
    public UserDetailsServiceImpl() {
    	
    }
    public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        com.example.demo.entity.User user = userRepository.getUserByEmail(email);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
    
	@Override
	public com.example.demo.entity.User save(com.example.demo.entity.User user) {
	
		return userRepository.save(user);
	}
	@Override
	public void updateUser(com.example.demo.entity.User existingUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
