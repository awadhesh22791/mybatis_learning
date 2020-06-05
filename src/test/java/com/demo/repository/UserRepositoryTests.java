package com.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.User;

@SpringBootTest
public class UserRepositoryTests {

	@Autowired UserRepository userRepository;
	
	@Test
	public void findAllTest() {
		List<User> allUser = userRepository.findAll();
		assertTrue(allUser.size()>0);
	}
	
	@Test
	public void findByIdTest() {
		User firstUser=userRepository.findById(1);
		assertNotNull(firstUser);
		assertEquals(1, firstUser.getId());
		User noUser=userRepository.findById(22);
		assertNull(noUser);
	}
	
	@Test
	public void insertTest() {
		User firstUser=User.builder().firstName("Shannon").lastName("Holland").email("shannon.holland@email.com").build();
		int newUserId=userRepository.insert(firstUser);
		User foundFirstUser=userRepository.findById(newUserId);
		assertNotNull(foundFirstUser);
	}
	
	@Test
	public void updateTest() {
		User newUser=User.builder().firstName("Martha").lastName("Day").email("martha.day@email.com").build();
		int newUserId=userRepository.insert(newUser);
		User existingUser=userRepository.findById(newUserId);
		existingUser.setFirstName("Layla");
		userRepository.update(existingUser);
		existingUser=userRepository.findById(newUserId);
		assertEquals("Layla", existingUser.getFirstName());
	}
}
