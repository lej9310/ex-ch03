package com.lej.crud_proj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lej.crud_proj.domain.Student;
import com.lej.crud_proj.service.StudentService;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor:final 또는 @NonNull 필드를 대상으로 생성자를 자동으로 생성
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

	private final StudentService studentService;

	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();
	}
}