package com.lej.calculator2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService2 {

	public double add(double num1, double num2) {
		return (num1 + num2);
	}

	public double subtract(double num1, double num2) {
		return (num1 - num2);
	}

	public double multiply(double num1, double num2) {
		return (num1 * num2);
	}

	public double divide(double num1, double num2) {
		if (num2 == 0) {
			throw new ArithmeticException("0으로 나눌 수 없음");
		}
		return (num1 / num2);
	}

	public double calculate(double num1, double num2, String operation) {
		//  연산자(operation)에 따라 결과 출력
		return switch (operation) {
			case "+" -> add(num1, num2);
			case "-" -> subtract(num1, num2);
			case "*" -> multiply(num1, num2);
			case "/" -> divide(num1, num2);
			default -> throw new IllegalArgumentException("적합한 연산자가 없음" + operation);
		};		
	}

}
