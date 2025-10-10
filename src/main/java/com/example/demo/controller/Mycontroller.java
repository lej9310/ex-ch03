package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MyService;

//경로 제어
@RestController
public class Mycontroller {

	// 자바 방식 - 객체 생성
	// MyService myService = new MyService;

	private final MyService myService;

	public Mycontroller(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public String getMethodName() {
		System.out.println("====== 루트 경로 ======");
		return myService.sayhello("안녕");
	}

	@GetMapping("/ex70_str")
	public String ex70_str() {
		System.out.println("====== ex70_str ======");
		return myService.ex70_str();
	}
	
	@GetMapping("/ex70_int")
	public Integer ex70_int() {
		System.out.println("====== ex70_int ======");
		return myService.ex70_int();
	}
	
	@GetMapping("/ex72_for")
	public String ex72_for() {
		System.out.println("====== ex72_for ======");
		return myService.ex72_for();
	}
	
	@GetMapping("/ex73_while")
	public String ex73_while() {
		System.out.println("====== ex73_while ======");
		return myService.ex73_while();
	}
	
	@GetMapping("/ex78_ArrList")
	public String ex78_ArrList() {
		System.out.println("====== ex78_ArrayList ======");
		return myService.ex78_ArrList();
	}
}
