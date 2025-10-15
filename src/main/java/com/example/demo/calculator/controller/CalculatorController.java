package com.example.demo.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.calculator.dto.CalculationRequest;
import com.example.demo.calculator.dto.CalculatorResponse;
import com.example.demo.calculator.service.CalculatorService;

@RestController
@RequestMapping("calculator") // 웹 요청을 처리해야 할 URL 패턴을 지정
public class CalculatorController {

	// 의존성 주입 예제
	// 객체가 필요로 하는 의존 대상 객체를 외부에서 주입

	// 사용법 1. 의존성을 Autowired 어노테이션을 통해 주입하는 방법
	// @Autowired
	// CalculatorService calculatorService; // 생성자 주입

	// 사용법 2. 의존성을 생성자를 통해 주입받는 방법: 객체 obj
	// 2-1. 의존성 선언
	CalculatorService calculatorService;

	// 2-2. 생성자 선언
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	// POST 메서드: 클라이언트가 서버에 새로운 리소드를 생성하거나 기존 리소스 업데이트
	// PostMapping 수정 >> URL 경로: /calculate >> http://[서버주소]:[포트]/calculate로 POST 요청
	// request: 클라이언트가 서버에 데이터 전송 (ex. 회원가입-ID, PW, email)
	// response: 서버가 요청을 처리한 후 응답을 반환 (ex. 회원가입 축하 메세지)
	@PostMapping("/calculate")
	public CalculatorResponse calculate(@RequestBody CalculationRequest request) {
		String result = calculatorService.calculate(request.getNum1(), request.getNum2(), request.getOperation());
		return new CalculatorResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);		
	}

	// ========================
//	@GetMapping("/add")
//	public String add(@RequestParam double num1, @RequestParam double num2) {
//		String result = String.valueOf(num1 + num2);
//		return result;
//	}

//	@GetMapping("/add")
//	public String add(@RequestParam double num1, @RequestParam double num2) {
//		return calculatorService.add(num1, num2);
//	}

	// http://localhost:8090/Calculator/add?num1=5&num2=10
	@GetMapping("/add")
	public CalculatorResponse add(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.add(num1, num2);
		return new CalculatorResponse(num1, num2, "ADD", result);
	}

	// ========================
//	@GetMapping("/subtract")
//	public String subtract(@RequestParam double num1, @RequestParam double num2) {
//		return calculatorService.subtract(num1, num2);
//	}

	// http://localhost:8090/Calculator/subtract?num1=5&num2=10
	@GetMapping("/subtract")
	public CalculatorResponse subtract(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.subtract(num1, num2);
		return new CalculatorResponse(num1, num2, "SUBTRACT", result);
	}

	// ========================
//	@GetMapping("/multiply")
//	public String multiply(@RequestParam double num1, @RequestParam double num2) {
//		return calculatorService.multiply(num1, num2);
//	}

	// http://localhost:8090/Calculator/multiply?num1=5&num2=10
	@GetMapping("/multiply")
	public CalculatorResponse multiply(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.multiply(num1, num2);
		return new CalculatorResponse(num1, num2, "MULTIPLY", result);
	}

	// ========================
//	@GetMapping("/divide")
//	public String divide(@RequestParam double num1, @RequestParam double num2) {
//		return calculatorService.divide(num1, num2);
//	}

	// http://localhost:8090/Calculator/divide?num1=5&num2=10
	@GetMapping("/divide")
	public CalculatorResponse divide(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.divide(num1, num2);
		return new CalculatorResponse(num1, num2, "DIVIDE", result);
	}

}
