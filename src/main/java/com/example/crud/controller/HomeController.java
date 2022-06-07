package com.example.crud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crud.config.StudentMgmtException;
import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping({ "/home" })
	public String home(Model model) throws StudentMgmtException {
		List<Student> students = studentService.getStudents();
		if(students.isEmpty())
			throw new StudentMgmtException("No student records found.");
		model.addAttribute("stlist", students);
		return "home";
	}
	
	@GetMapping({ "/create" })
	public String createStudent() {
		return "admin/addStudent";
	}

	@PostMapping({ "/addStudent" })
	public String addStudent(@ModelAttribute Student st) throws StudentMgmtException {
		Student stu = null;
		if (st.getId() != null) {
			try {
				stu = studentService.getStudentById(st.getId().intValue());
			stu.setName(st.getName());
			stu.setAddress(st.getAddress());
			studentService.addStudent(stu);
			} catch (Exception e) {
				throw new StudentMgmtException("Student with Id "+st.getId()+ " not found");
			}
		} else {
			studentService.addStudent(st);
		}
		return "redirect:/home";
	}

	@GetMapping({ "/update/{id}" })
	public String updateStudent(@PathVariable int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("stu", student);
		return "admin/addStudent";
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
