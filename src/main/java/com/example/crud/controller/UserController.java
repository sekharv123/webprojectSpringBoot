package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping({ "/register" })
	public String createStudent() {
		return "addUser";
	}
	
	@PostMapping({ "/addUser" })
	public String addUser(@ModelAttribute User user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userService.addUser(user);
		return "redirect:/login";
	}
	
	@GetMapping({ "/users" })
	public String userSummary(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("userList", users);
		return "admin/userSummary";
	}

}
