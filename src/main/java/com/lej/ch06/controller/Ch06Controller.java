package com.lej.ch06.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ch06")
public class Ch06Controller {

	
//	@GetMapping("/")
//	public String chNum() {
//		System.out.println("http://localhost:8090/ch06");
//		return ch06Service.chNum();
//	}

	// 6-2-1. ==================================
	@GetMapping("/article621-get")
	public String createArticle(@RequestParam String title, @RequestParam String content) {
//		String result = String.format("title=%s / content=%s", title, content);
		String result = "제목: " + title + "<br>내용: " + content;
		System.out.println("http://localhost:8090/ch06/article621-get");
		return result;
	}

}
