package com.example.calculator.service;

import org.springframework.stereotype.Service;

// @Service 어노테이션:클래스가 비즈니스 로직을 처리하는 서비스 레이어의 일부분임을 명시
// 다른 빈에서 해당 클래스를 주입받아 사용
@Service
public class CalculatorService {

	public String add() {
		return "덧셈_생성자 사용";
	}

	public String add(double num1, double num2) {
		String result = String.valueOf(num1 + num2);
		return result;
	}

	// ========================
	public String subtract() {
		return "뺄셈";
	}

	public String subtract(double num1, double num2) {
		String result = String.valueOf(num1 - num2);
		return result;
	}

	// ========================
	public String multiply() {
		return "곱셈";
	}

	public String multiply(double num1, double num2) {
		String result = String.valueOf(num1 * num2);
		return result;
	}

	// ========================
	public String divide() {
		return "나눗셈";
	}

	public String divide(double num1, double num2) {
		if (num2 == 0) {
			throw new ArithmeticException("나눌 수 없음");
		}
		String result = String.valueOf(num1 / num2);
		return result;
	}

	// ========================
	public String calculate(double num1, double num2, String operation) {

		return switch (operation.toUpperCase()) {
		case "ADD" -> add(num1, num2);
		case "SUBTRACT" -> subtract(num1, num2);
		case "MULTIPLY" -> multiply(num1, num2);
		case "DIVIDE" -> {
			if (num2 == 0) {
				throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
			}
			yield divide(num1, num2);
		}
		default -> throw new IllegalArgumentException("Unsupported operation:" + operation);
		};
	}

}
