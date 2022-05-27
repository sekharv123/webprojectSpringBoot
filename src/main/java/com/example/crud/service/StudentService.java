package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		Student stu = (Student) this.studentRepository.save(student);
		return stu;
	}

	public List<Student> getStudents() {
		List<Student> list = this.studentRepository.findAll();
		return list;
	}

	public Student getStudentById(int id) {
		Optional<Student> st = this.studentRepository.findById(Integer.valueOf(id));
		Student student = null;
		if (st.isPresent())
			student = st.get();
		return student;
	}

	public void deleteStudent(int id) {
		this.studentRepository.deleteById(Integer.valueOf(id));
	}

	public void deleteAllStudents() {
		this.studentRepository.deleteAll();
	}

}
