package com.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(allUser.size(), 1);
	}
}
