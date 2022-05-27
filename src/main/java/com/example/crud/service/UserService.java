package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public User getUserByName(String userName) {
		Optional<User> optUser = userRepository.findByUsername(userName);
		User user = null;
		if (optUser.isPresent())
			user = optUser.get();
		return user;
	}
	
	public List<User> getUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}
}
