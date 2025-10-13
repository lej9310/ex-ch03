package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	private static final Logger Log = LoggerFactory.getLogger(MyService.class);

	public String sayhello(String hi) {
		String msg = hi + ", 좋은 하루~!";

		// System.out.println(msg);
		Log.info(msg);
//		Log.debug(msg);
//		Log.warn(msg);
//		Log.error(msg);

		return msg;
	}

	// 3-2-1 ===========================================
//	public String ex70_str() {
//		String result = "";
//		int num = 2;
//		if (num == 1) {
//			System.out.println("if 블록입니다.");			
//		} else if (num == 2) {
//			System.out.println("else if 블록입니다.");			
//		} else {
//			System.out.println("else 블록입니다.");			
//		}

	public String ex70_str() {
		String result = "";
		int num = 2;
		if (num == 1) {
			result = "if 블록입니다.";
		} else if (num == 2) {
			result = "else if 블록입니다.";
		} else {
			result = "else 블록입니다.";
		}

		// System.out.println(result);
		Log.info(result);

		String msg = "ex70_str 결과: " + result;
		return msg;
	}

	public Integer ex70_int() {
		Log.info("999");
		return 999;
	}

	// 3-2-2 ===========================================
	public String ex72_for() {
		int[] array = { 1, 2, 3, 4, 5 };
		String result = "";

		for (int i = 0; i < array.length; i++) {
			String currentResult = "i = " + array[i];
			result += currentResult + "<br>";

			Log.info(currentResult);
		}

		String msg = "ex72_for 결과: <br>" + result;
		System.out.println(msg);
		return msg;
	}

	// 3-2-3 ===========================================
	public String ex73_while() {

		int[] array = { 1, 2, 3, 4, 5 };
		int i = 0;
		String result = "";

		while (i < array.length) {
			String currentResult = "i = " + array[i];
			Log.info(currentResult);
			result += currentResult + ", ";
			i++;
		}

		if (!result.isEmpty()) {
			result = result.substring(0, result.length() - 2);
		}

		String msg = "ex73_while 결과: " + result;
		System.out.println(msg);
		return msg;
	}

	// 3-2-4 ===========================================
	public interface Car {
		public String getColor();
	}

	public class Sonata implements Car {
		public Sonata() {
			Log.info("Sonata 출고");
		}

		@Override
		public String getColor() {
			return "(Sonata) 색상: RED";
		}
	}

	public class K5 implements Car {
		public K5() {
			Log.info("K5 출고");
		}

		@Override
		public String getColor() {
			return "(K5) 색상: YELLOW";
		}
	}

	public String ex75_polymorphism() {
		Car car1 = new Sonata();
		String result1 = car1.getColor();
		Car car2 = new K5();
		String result2 = car2.getColor();

		String msg = "차 2대 출고 완료<br>- " + result1 + "<br>- " + result2;
		return msg;
	}

	// 3-2-5 ===========================================
	// Java List 컬렉션
	public String ex76_ArrList() {
		// ArrayList<Integer>: ArrayList에 Integer 타입 저장
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);

		Log.info("list 내용: " + list);

		String msg = "ex76_ArrList<Integer> 결과: " + list;
		System.out.println(msg);
		return msg;
	}

	// 3-2-6 ===========================================
	public String ex78_ArrList() {

		// ArrayList<String>: ArrayList에 String 타입 저장
		List<String> list = new ArrayList<String>();
		list.add("public");
		list.add("static");
		list.add("void");

		// for문 >> list 요소 차례대로 출력
		for (int i = 0; i < list.size(); i++) {
			Log.info("list 내용: " + list.get(i));
		}

		// list의 두번째 요소 제거
		list.remove(1);
		System.out.println(list); // [public, void]

		int voidIndex = list.indexOf("void"); // 1 반환

		String msg = "void의 index = " + voidIndex;
		System.out.println(msg);
		return msg;
	}

	// 3-2-7 & 3-2-8 ===========================================
	public String ex79_iden_equal() {

		boolean result1;
		boolean result2;

		String str1 = new String("is same?");
		String str2 = new String("is same?");

		result1 = str1 == str2;
		Log.info("str1과 str2가 같은가? " + result1); // false
		result2 = str1.equals(str2);
		Log.info("str1과 str2가 같은가? " + result2); // true

		String msg1 = "동일성(identity) 결과: " + result1;
		System.out.println(msg1);

		String msg2 = "동등성(equality) 결과: " + result2;
		System.out.println(msg2);

		// 두 결과를 합친 문자열을 반환
		return msg1 + "<br>" + msg2;
	}

	// 3-3-1 ===========================================

	public String ex85_lambda() {
		List<String> list = new ArrayList<String>();

		list.add("public");
		list.add("static");
		list.add("void");

		// 1. 익명 클래스 코드
		// list.sort() 메소드: 리스트 요소를 정렬
//		list.sort(new Comparator<String>() {
//			@Override
//			public int compare(String str1, String str2) {
//				return str1.compareTo(str2);
//			}
//		});

		// 2. 람다 표현식 코드
		// list.sort((str1, str2) -> str1.compareTo(str2));
		list.sort(Comparator.naturalOrder());

		String msg = "ex85_lambda 결과: " + list;
		System.out.println(msg);
		return msg;
	}

	// 3-3-2 ===========================================
	public String ex88_streamAPI() {
		List<String> list = new ArrayList<String>();

		list.add("public");
		list.add("static");
		list.add("void");

		// 스트림 API: 컬렉션에 담긴 데이터 처리
		// 스트림 API가 호출되는 컬렉션 객체의 요소들을 인자로 들어온 람다 표현식을 통해 처리

		// 리스트 각 요소를 콘솔에 출력
		// list.stream().forEach(str -> System.out.println(str));
		list.stream().forEach(System.out::println);

		String result = list.stream().collect(Collectors.joining("<br>"));

		String msg = "ex88_streamAPI 결과: <br>" + result;
		System.out.println(msg);
		return msg;
	}

	// 3-3-3 ===========================================
	public String ex89_streamAPI() {
		// 1. Integer 배열 생성 및 List 변환
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// Arrays.asList: 배열로부터 List 인터페이스 객체 생성
		// 제네릭스<> 사용 >> 리스트의 타입 설정 >> String 들어가면 오류
		List<Integer> list = Arrays.asList(integerArray);
		List<Integer> evenList = new ArrayList<Integer>();

		// 2. 스트림 API 활용: 짝수 필터링
		for (int i = 0; i < list.size(); i++) {
			Integer number = list.get(i);
			if (number % 2 == 0) { // 2로 나눴을 때의 나머지가 0이면 2의 배수이다.
				evenList.add(number);
			}	
		}		

		for (int i = 0; i < evenList.size(); i++) {
			System.out.println(evenList.get(i));
		}

		return null;
	}

}
