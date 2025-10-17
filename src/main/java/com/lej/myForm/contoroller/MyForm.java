package com.lej.myForm.contoroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lej.myForm.dto.ArticleRequest;

@RestController
public class MyForm {

	// 1. get 방식 >> 웹주소창에 테스트: 입력값이 url에 표시 => 보안 취약
	// http://localhost:8080/article-get?title=get&content=get
	@GetMapping("/article-get")
	public String articleGet(@RequestParam String title, @RequestParam String content) {
		String result = "제목: " + title + "<br>내용: " + content;
		return result;
	}

	 	
	//	@PostMapping("/article.post")
	//	public String articlePost(@RequestBody ArticleRequest request) {
	//		String result = "제목: " + request.title() + "<br>내용: " + request.content();
	//		return result;
	//	}
	
	// 2. post 방식 >> 웹주소창에 테스트: url에 표시 안 됨
	// http://localhost:8080/article-post
	@PostMapping("/article-post")
	public String articlePost(@ModelAttribute ArticleRequest request) {
		String result = "제목: " + request.title() + "<br>내용: " + request.content();
		return result;
	}
	
	//3. post 방식 >> Postman에 테스트
	// http://localhost:8080/article-postman
	@PostMapping("/article-postman")
	public String articlePostman(@RequestBody ArticleRequest request) {
		String result = "제목: " + request.title() + "\n내용: " + request.content();
		return result;
	}
	
	//4. post 방식 >> Postman formdata에 테스트
	// http://localhost:8080/article-auto
	@PostMapping("/article-auto")
	public String articleAuto(ArticleRequest request) {
		String result = "제목: " + request.title() + "\n내용: " + request.content();
		return result;
	}
	
	
}
