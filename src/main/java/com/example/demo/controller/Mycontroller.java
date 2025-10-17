package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MyService;

//경로 제어
@RestController
public class Mycontroller {

	// 자바 방식 - new 연산자를 사용한 객체 생성
	// MyService myService = new MyService;

	private final MyService myService;

	public Mycontroller(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/")
	public String getMethodName() {
		System.out.println("====== 루트 경로 ======");
		return myService.sayhello("안녕");
	}

	// 3-2-1.
	@GetMapping("/ex70_str")
	public String ex70_str() {
		System.out.println("====== ex70_str ======");
		return myService.ex70_str();
	}
	
	@GetMapping("/ex70_int")
	public Integer ex70_int() {
		System.out.println("====== ex70_int ======");
		return myService.ex70_int();
	}
	
	// 3-2-2.
	@GetMapping("/ex72_for")
	public String ex72_for() {
		System.out.println("====== ex72_for ======");
		return myService.ex72_for();
	}
	
	// 3-2-3.
	@GetMapping("/ex73_while")
	public String ex73_while() {
		System.out.println("====== ex73_while ======");
		return myService.ex73_while();
	}
	
	// 3-2-4.
	// 다형성(polymorphism) - 상속 & 인터페이스
	//인터페이스(부모 클래스)의 참조변수로 구현클래스(자식)의 인스턴스를 넣어 사용 가능
	@GetMapping("/ex75_polymorphism")
	public String ex75_polymorphism() {
		System.out.println("====== ex75_다형성(polymorphism) ======");
		return myService.ex75_polymorphism();
	}
	
	// 3-2-5.
	// 인터페이스: 메서드 선언만 가지고 구현은 없음. 객체 생성 불가. 변수는 상수만 가능. 다중 구현 가능. implements로 구현체와 연계(List, Set, Map...)
	// 구현체: 인터페이스를 구현하는 클래스. 메서드의 실제 동작 작성. 객체 생성 가능(ArrayList)
	// ArrayList: List 인터페이스의 구현체. 배열처럼 여러개 데이터 다룸
	@GetMapping("/ex76_ArrList")
	public String ex76_ArrList() {
		System.out.println("====== ex76_ArrayList ======");
		return myService.ex76_ArrList();
	}
	
	// 3-2-6.
	@GetMapping("/ex78_ArrList")
	public String ex78_ArrList() {
		System.out.println("====== ex78_ArrayList ======");
		return myService.ex78_ArrList();
	}
	
	// 3-2-7.
	// 동일성(identity)과 동등성(equality) 비교
	@GetMapping("/ex79_iden_equal")
	public String ex79_iden_equal() {
		System.out.println("====== ex79_identity/equality ======");
		return myService.ex79_iden_equal();
	}
	
	// 3-3-1.
	// 람다 표현식(Lambdam Expression) >> 익명함수 
	@GetMapping("/ex85_lambda")
	public String ex85_lambda() {
		System.out.println("====== ex85_lambda ======");
		return myService.ex85_lambda();
	}
	
	// 3-3-2. 스트림 API
	@GetMapping("/ex88_streamAPI")
	public String ex88_streamAPI() {
		System.out.println("====== ex88_streamAPI ======");
		return myService.ex88_streamAPI();
	}

	// 3-3-3.
	@GetMapping("/ex89_for")
	public String ex89_for() {
		System.out.println("====== ex89_streamAPI : for문 사용 ======");
		return myService.ex89_for();
	}
	
	// 3-3-4.
	@GetMapping("/ex90_filter")
	public String ex90_filter() {
		System.out.println("====== ex90_filter : evenList======");
		return myService.ex90_filter();
	}
	
	// 3-3-5.
	@GetMapping("/ex91_forEach")
	public String ex91_streamAPI() {
		System.out.println("====== ex91_forEach ======");
		return myService.ex91_forEach();
	}
	
	// 3-3-7.
	@GetMapping("/ex93_distinct")
	public String ex93_distinct() {
		System.out.println("====== ex93_streamAPI: distinctList ======");
		return myService.ex93_distinct();
	}
	
	// 3-3-8.
	@GetMapping("/ex93_map")
	public String ex93_map() {
		System.out.println("====== ex93_java map() ======");
		return myService.ex93_map();
	}
	
	// 3-3-9.
	@GetMapping("/ex94_null")
	public String ex94_null() {
		System.out.println("====== ex94_java null 반환 ======");
		return myService.ex94_null();
	}
	
	// 3-3-11.
	@GetMapping("/ex95_optional")
	public String ex95_optional() {
		System.out.println("====== ex95_비어 있는 optional 반환 ======");
		return myService.ex95_optional();
	}
	
	// 3-3-13. & 3-3-14.
	@GetMapping("/ex97_optional")
	public String ex97_optional() {
		System.out.println("====== ex97_안티패턴 & 안티패턴 해결 ======");
		return myService.ex97_optional();
	}	
	
	
}
