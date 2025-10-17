package com.lej.ch05.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lej.ch05.controller.service.Ch05Service;

@RestController
@RequestMapping("/ch05")
public class Ch05Controller {

	// 의존성 선언
	private final Ch05Service ch05Service;

	public Ch05Controller(Ch05Service ch05Service) {
		this.ch05Service = ch05Service;
	}

	// 5-2-1. ==================================
	@GetMapping("/")
	public String hello() {
		System.out.println("http://localhost:8090/ch05");
		return ch05Service.hello("Hello");
	}

	// 5-2-2. ==================================
	@GetMapping("/bye")
	public String buy() {
		System.out.println("http://localhost:8090/ch05/buy");
		return ch05Service.buy("Bye");
	}

	@GetMapping("/chapter")
	public String chNum() {
		System.out.println("http://localhost:8090/ch05/chapter");
		return ch05Service.chNum();
	}

	// 5-2-3. ==================================
	// @RequestMapping("/ch05/bye")
	// public String hello() {
	// return ch05Service.hello("Hello");
	// }

	// 5-2-4. ==================================
	@GetMapping("/hello2")
	public String hello2() {
		System.out.println("http://localhost:8090/ch05/hello2");
		return ch05Service.hello2();
	}

	// 정적 파일 사용
	// "/src/main/resources/static" 디렉토리에 HTML 파일 생성
	// http://localhost:8090/backend.html

}
