package com.lej.ch06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Controller  ===============================
// MVC(Model-View-Controller) 패턴을 지원
// ModelAndView 또는 뷰를 렌더링하는 String을 반환
// HTTP 응답 본문에 객체를 직접 반환하려면, @Controller 메서드 내에 @ResponseBody를 붙여야 함

// @RestController >> @Controller + @ResponseBody ============================
// RESTful 웹 서비스 개발을 목적
// HTTP 응답 본문에 JSON이나 XML 등의 데이터를 직접 반환

@RestController
@RequestMapping("/ch06")
public class Ch06Controller {

	// 6-2-1. ==================================
	@GetMapping("/article621-get")
	public String createArticle(@RequestParam String title, @RequestParam String content) {
		String result = String.format("title=%s / content=%s", title, content);
		System.out.println("http://localhost:8090/ch06/article621-get?title=title&content=content");
		return result;
	}

	@PostMapping("/article621-post")
	public String createArticlePost(@RequestParam String title, @RequestParam String content) {
		String result = String.format("title=%s / content=%s", title, content);
		return result;
	}

}
