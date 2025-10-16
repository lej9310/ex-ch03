package com.lej.calculator2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lej.calculator2.dto.CalculatorResponse2;
import com.lej.calculator2.service.CalculatorService2;

@RestController
@RequestMapping("calculator2")
public class CalculatorController2 {

	// 1. java 방식 >> new 생성자
	// CalculatorService calculatorService = new CalculatorService();

	// 2-1. Spring 방식
	// @Autowired
	// CalculatorService calculatorService;

	// 2-2. Spring 방식: 생성자를 통한 객체 주입
	CalculatorService2 calculatorService2;

	public CalculatorController2(CalculatorService2 calculatorService2) {
		this.calculatorService2 = calculatorService2;
	}

	// ==============================
	// 1. 문자열 리턴
	// @GetMapping("/add")
	// public String add() {
	// return String("/덧셈");
	// }

	// 2. 더블타입의 연산결과 리턴
	// @GetMapping("/add")
	// public double add() {
	// return (10 + 5);
	// }

	// 3. obj.methodName: 서비스 로직으로 연산 결과를 리턴
	// @GetMapping("/add")
	// public double add() {
	// return calculatorService.add(10, 5);
	// }

	// 4. "사용자가 입력한 값을 받아서", 서비스 로직으로 연산 결과를 리턴
	// @GetMapping("/add")
	// public double add(@RequestParam int num1, @RequestParam int num2) {
	// return calculatorService.add(num1, num2);
	// }

	// CalculatorResponse calculatorResponse = new CalculatorResponse(num1, num2,
	// "add", num1+num2);

	// 5. 서비스 로직으로 연산 결과 얻기 => 결과 포멧을 dto(record type) 사용 => return 타입을 dto로 수정
	// http://localhost:8090/calculator/add?num1=10&num2=5
	@GetMapping("/add")
	public CalculatorResponse2 add(@RequestParam int num1, @RequestParam int num2) {
		double result = calculatorService2.add(num1, num2);
		return new CalculatorResponse2(num1, num2, "add", result);
	}

	// http://localhost:8090/calculator/subtract?num1=10&num2=5
	@GetMapping("/subtract")
	public CalculatorResponse2 subtract(@RequestParam int num1, @RequestParam int num2) {
		double result = calculatorService2.subtract(num1, num2);
		return new CalculatorResponse2(num1, num2, "subtract", result);
	}

	// http://localhost:8090/calculator/multiply?num1=10&num2=5
	@GetMapping("/multiply")
	public CalculatorResponse2 multiply(@RequestParam int num1, @RequestParam int num2) {
		double result = calculatorService2.multiply(num1, num2);
		return new CalculatorResponse2(num1, num2, "multiply", result);
	}

	// http://localhost:8090/calculator/divide?num1=10&num2=5
	@GetMapping("/divide")
	public CalculatorResponse2 divide(@RequestParam int num1, @RequestParam int num2) {
		double result = calculatorService2.divide(num1, num2);
		return new CalculatorResponse2(num1, num2, "divide", result);
	}

	// POST 메소드 >> body로 받기 =======================================
	// [Postman >> PostMapping 테스트하기]
	// http://localhost:8090/calculator/calculate
	// {
	// "num1": 100,
	// "num2": 50,
	// "operation": "/"
	// }

	// 1. entity 문자열 리턴
	// @PostMapping("/calculate")
	// private String postMethodName(String entity) {
	// return entity;
	// }

	// 2.
	// @RequestBody: 객체 방식으로 값을 저장
	// result: 연산 결과값 저장
	// 출력 포맷: 객체방식으로 값을 화면에 출력
	// @PostMapping("/calculate")
	// public CalculatorResponse postMethodName(@RequestBody CalculatorResponse
	// request) {
	// double result = calculatorService.add(request.getNum1(), request.getNum2());
	// return new CalculatorResponse(request.getNum1(), request.getNum2(),
	// request.getOperation(), result);
	// }

	// 3.
	@PostMapping("/calculate")
	public CalculatorResponse2 postMethodName(@RequestBody CalculatorResponse2 request) {
		double result = calculatorService2.add(request.getNum1(), request.getNum2());
		return new CalculatorResponse2(request.getNum1(), request.getNum2(), request.getOperation(), result);
	}

}
