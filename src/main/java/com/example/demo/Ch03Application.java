package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo", "com.lej.calculator2", "com.lej.myForm", "com.lej.tymleaf",
		"com.lej.ch05", "com.lej.ch06" })
public class Ch03Application {

	// 1. Logger 객체 생성
	// SLF4J(Simple Logging Facade for Java) 프레임워크의 LoggerFactory 이용
	private static final Logger Log = LoggerFactory.getLogger(Ch03Application.class);

	// 2. 메인 메소드: Spring Boot 애플리케이션 실행
	public static void main(String[] args) {
		SpringApplication.run(Ch03Application.class, args);
	}

	// 3. CommandLineRunner Bean 정의
	// 해당 메소드의 반환값이 Spring의 애플리케이션 컨텍스트에 등록
	// run() 메소드: args(커맨드 라인 인자)를 받아 실행하는 람다(lambda) 표현식을 반환
	// 람다 블록 내에서, 로거(Log)를 사용하여 다양한 로그 메시지를 출력
	@Bean
	public CommandLineRunner run() {
		return args -> {
			Log.info("================");
			Log.info("정보 수준"); // 일반적인 진행 상황이나 상태 정보 기록
			Log.debug("디버그 수준"); // 디버깅을 위한 상세 정보 기록
			Log.warn("경고 수준"); // 잠재적 문제나 비정상적 상태
			Log.error("에러 수준"); // 예외 발생하거나 심각한 오류
			Log.info("================");
		};
	}

}
