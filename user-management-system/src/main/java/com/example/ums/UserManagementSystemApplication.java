package com.example.ums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ums.entity.User;
import com.example.ums.repository.UserRepository;

@SpringBootApplication
public class UserManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user = new User("Palani", "Vembu", "palani@gmail.com");
		 * userRepository.save(user);
		 * 
		 * User user1 = new User("Selvam", "Muthu", "selvam@gmail.com");
		 * userRepository.save(user1);
		 */
		
	}

}
