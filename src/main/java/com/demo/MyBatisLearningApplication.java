package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@SpringBootApplication
public class MyBatisLearningApplication implements CommandLineRunner {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(MyBatisLearningApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User newUser=new User();
		newUser.setEmail("jennifer.james@email.com");
		newUser.setFirstName("Jennifer");
		newUser.setLastName("James");
		int newUserId=userRepository.insert(newUser);
		logger.info("Inserting -> {}", newUserId);
		logger.info("Inserted user -> {}",userRepository.findAll().toString());
		User existingUser=userRepository.findById(newUserId);
		logger.info("Found user -> {}",existingUser.toString());
		existingUser.setFirstName("Anna");
		existingUser.setLastName("Howard");
		existingUser.setEmail("anna.howard@email.com");
		logger.info("Updating user -> {}",userRepository.update(existingUser));
		logger.info("Update user -> {}",userRepository.findById(existingUser.getId()).toString());
		logger.info("Deleting user -> {}",userRepository.delete(newUserId));
	}

}
