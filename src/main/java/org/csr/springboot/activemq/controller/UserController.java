package org.csr.springboot.activemq.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.csr.springboot.activemq.model.User;
import org.csr.springboot.activemq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId){
		User user = userRepository.findOne(userId);
		if(user == null) {
			throw new NoSuchElementException("User not availbele for Id :"+userId);
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		System.out.println(user); // Just to inspect values for demo
		return userRepository.save(user);
	}

}
