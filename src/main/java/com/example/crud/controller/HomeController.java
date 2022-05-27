package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping({ "/home" })
	public String home(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("stlist", students);
		return "home";
	}

	@GetMapping({ "/create" })
	public String createStudent() {
		return "addStudent";
	}

	@PostMapping({ "/addStudent" })
	public String addStudent(@ModelAttribute Student st) {
		Student stu = null;
		if (st.getId() != null) {
			stu = studentService.getStudentById(st.getId().intValue());
			stu.setName(st.getName());
			stu.setAddress(st.getAddress());
			studentService.addStudent(stu);
		} else {
			studentService.addStudent(st);
		}
		return "redirect:/home";
	}

	@GetMapping({ "/update" })
	public String updateStudent(@RequestParam int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("stu", student);
		return "addStudent";
	}

	@GetMapping({ "/delete" })
	public String deleteteStudent(@RequestParam int id) {
		studentService.deleteStudent(id);
		return "redirect:/home";
	}

	//@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping({ "/deleteAll" })
	public String deleteteAllStudents() {
		studentService.deleteAllStudents();
		return "redirect:/home";
	}

	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully!.");
		return "login";
	}
}
