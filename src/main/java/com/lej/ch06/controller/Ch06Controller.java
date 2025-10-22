package com.lej.ch06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lej.ch06.dto.Ch06Request;

// @Controller  ===========================================================
// MVC(Model-View-Controller) 패턴을 지원
// ModelAndView 또는 뷰를 렌더링하는 String을 반환
// HTTP 응답 본문에 객체를 직접 반환하려면, @Controller 메서드 내에 @ResponseBody를 붙여야 함

// @RestController >> @Controller + @ResponseBody =========================
// RESTful 웹 서비스 개발을 목적
// HTTP 응답 본문에 JSON이나 XML 등의 데이터를 직접 반환

@RestController
@RequestMapping("ch06")
public class Ch06Controller {

	// 6-2-1. ==================================
	
	// 1. GET 메서드 >> @RequestParam >> URL 노출
	// 웹 주소창에 테스트: http://localhost:8090/ch06/article-6-2-1-get?title=title&content=content
	@GetMapping("/article-6-2-1-get")
	public String createArticleGet(@RequestParam String title, @RequestParam String content) {
		String result = String.format("title=%s / content=%s", title, content);
		return result;
	}
	
	// 2. POST 메서드: @ModelAttribute >> 웹주소창에 테스트: url에 표시 안 됨
	// http://localhost:8090/ch06/article-6-2-1-post
	@PostMapping("/article-6-2-1-post")
	public String ArticlePost(@ModelAttribute Ch06Request ch06Request) {
		String result = String.format("title=%s / content=%s", ch06Request.title(), ch06Request.content());
		return result;
	}	

	// 3. POST 메서드: @RequestBody >> Postman에 테스트
	// http://localhost:8090/ch06/article-6-2-1-postman
	// {
	// "title": "title",
	// "content": "content"
	// }
	@PostMapping("/article-6-2-1-postman")
	public String ArticlePostman(@RequestBody Ch06Request ch06Request) {
		String result = String.format("title=%s / content=%s", ch06Request.title(), ch06Request.content());
		return result;
	}	
	

	// 6-2-2. 문자열 리턴 ==================================
	
}
