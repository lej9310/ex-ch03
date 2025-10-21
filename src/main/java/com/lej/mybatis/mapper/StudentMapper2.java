package com.lej.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lej.mybatis.domain.Student2;

@Mapper
public interface StudentMapper2 {

	// 전체 조회 =========================
	// 1. 조회
	List<Student2> findAll();

	// 단건 조회 =========================
	// 2. 등록(삽입)
	Student2 findById(Long id);

	void insert(Student2 student2);

	// SELECT * FROM student WHERE id = #{id}
	// Student findById(Long id);

	// @Insert("INSERT INTO student(NAME, email, age) VALUES\r\n" + " (#{name},
	// #{email}, #{age})")
	// @Options(useGeneratedKeys = true, keyProperty = "id")
	// void insert(Student student);

	// 3.수정
	void update(Student2 student2);	

	// @Update("UPDATE student\r\n"
	// + "SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
	// + "WHERE id = #{id}")	
	// void update(Student student);
	
	// 4. 삭제
	void delete(Long id);
	
	// @Delete("DELETE FROM student WHERE id = #{id}")
	// void delete(Long id);
}
