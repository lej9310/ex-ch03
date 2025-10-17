package com.lej.tymleaf.contoroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//==============================================
// @Controller 값
//==============================================
@Controller
public class Mytymleaf {

	// http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	// http://localhost:8080/hello_thymleaf
	@GetMapping("/hello_thymleaf")
	public String hello_thymleaf(Model model) {
		model.addAttribute("message", "스프링부트 타임리프 화면");
		return "hello_thymleaf";
	}
	
	// http://localhost:8080/hello_mustache
	@GetMapping("/hello_mustache")
	public String mustache(Model model) {
		model.addAttribute("message", "스프링부트 머스테치 화면");
		return "hello_mu";
	}
}
