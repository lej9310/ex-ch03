package com.lej.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lej.mybatis.domain.Student1;
import com.lej.mybatis.mapper.StudentMapper1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService1 {

	private final StudentMapper1 studentMapper1;

	public List<Student1> getAllStudents() {
		return studentMapper1.findAll();

		// DB연결전에 테스트 ===========================
		// List<Student> students = new ArrayList<>();
		// students.add(new Student() {{setId(1L); setName("홍길동");}});
		// students.add(new Student() {{setId(2L); setName("이몽룡");}});
		// students.add(new Student() {{setId(3L); setName("성춘향");}});
		// return students;
	}

	public Student1 getStudent(Long id) {
		return studentMapper1.findById(id);
	}

	// readOnly가 아닌 수정 메서드 >> 롤백 =====================
	@Transactional
	public void createStudent(Student1 student1) {
		studentMapper1.insert(student1);
	}

	@Transactional
	public void updateStudent(Student1 student1) {
		studentMapper1.update(student1);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper1.delete(id);		
	}	
	
}
