package com.lej.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lej.mybatis.domain.Student2;
import com.lej.mybatis.mapper.StudentMapper2;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor: Lombok에서 제공 >> 클래스의 특정 필드를 자동으로 포함시킨 생성자를 생성
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService2 {

	private final StudentMapper2 studentMapper2;

	public List<Student2> getAllStudents() {
		return studentMapper2.findAll();

		// DB연결전에 테스트 ===========================
		// List<Student> students = new ArrayList<>();
		// students.add(new Student() {{setId(1L); setName("홍길동");}});
		// students.add(new Student() {{setId(2L); setName("이몽룡");}});
		// students.add(new Student() {{setId(3L); setName("성춘향");}});
		// return students;
	}

	public Student2 getStudent(Long id) {
		return studentMapper2.findById(id);
	}

	// readOnly가 아닌 수정 메서드 >> 롤백 =====================
	@Transactional
	public void createStudent(Student2 student2) {
		studentMapper2.insert(student2);
	}

	@Transactional
	public void updateStudent(Student2 student2) {
		studentMapper2.update(student2);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper2.delete(id);
	}

}
