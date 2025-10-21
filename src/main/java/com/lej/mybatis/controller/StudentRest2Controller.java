package com.lej.mybatis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lej.mybatis.domain.Student2;
import com.lej.mybatis.service.StudentService2;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/mybatis/students")
@RequiredArgsConstructor
public class StudentRest2Controller {

	private final StudentService2 studentService2;

	// 전체 조회: GET http://localhost:8080/api/students
	@GetMapping
	public List<Student2> list() {
		return studentService2.getAllStudents();
	}

	// 단건 조회: GET http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Student2> detail(@PathVariable Long id) {
		Student2 student2 = studentService2.getStudent(id);
		if (student2 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student2);
	}

	// 등록: POST http://localhost:8080/api/students
	@PostMapping
	public ResponseEntity<Student2> create(@RequestBody Student2 student2) {
		studentService2.createStudent(student2);
		return ResponseEntity.ok(student2);
	}

	// 수정: PUT http://localhost:8080/api/students/1
	@PutMapping("/{id}")
	public ResponseEntity<Student2> update(@PathVariable Long id, @RequestBody Student2 student2) {
		student2.setId(id);
		studentService2.updateStudent(student2);
		return ResponseEntity.ok(student2);
	}

	// 삭제: DELETE http://localhost:8080/api/students
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delte(@PathVariable Long id) {
		studentService2.deleteStudent(id);
		return ResponseEntity.ok().build();
	}
}
