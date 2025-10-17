package com.lej.ch05.controller.service;

import org.springframework.stereotype.Service;

@Service
public class Ch05Service {

	// 5-2-1. ==================================
	public String hello(String hello) {
		return hello;
	}

	// 5-2-2. ==================================
	public String buy(String buy) {
		return buy;
	}

	public String chNum() {
		return "Ch05 예제입니다.";
	}

	// 5-2-4. ==================================
	public String hello2() {
		return "Hello <strong>Backend</strong>";
	}

}
