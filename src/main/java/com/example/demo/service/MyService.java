package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

	// 3-2-1. 조건문 if else ===========================================
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

	// 3-2-2. for문 ===========================================
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

	// 3-2-3. while문 ===========================================
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

	// 3-2-4. 다형성 ===========================================
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

	// 3-2-5. List 컬렉션 ===========================================
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

	// 3-2-6. ArrayList 출력 ===========================================
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

	// 3-2-7. 동일성 & 3-2-8 동등성 ===========================================
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

	// 3-3-1. 익명 클래스/람다표현식 ===========================================
	public String ex85_lambda() {
		List<String> list = new ArrayList<String>();

		list.add("public");
		list.add("static");
		list.add("void");

		// 1. 익명 클래스 코드
		// list.sort() 메소드: 리스트 요소를 정렬
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});

		// 2. 람다 표현식 코드
		list.sort((str1, str2) -> str1.compareTo(str2));
		// list.sort(Comparator.naturalOrder());

		String msg = "ex85_lambda 결과: " + list;
		System.out.println(msg);
		return msg;
	}

	// 3-3-2. java 스트림 API ===========================================
	public String ex88_streamAPI() {
		List<String> list = new ArrayList<String>();

		list.add("public");
		list.add("static");
		list.add("void");

		// 스트림 API: 컬렉션에 담긴 데이터 처리
		// 스트림 API가 호출되는 컬렉션 객체의 요소들을 인자로 들어온 람다 표현식을 통해 처리

		// 리스트 각 요소를 콘솔에 출력
		// list.stream().forEach(str -> System.out.println(str));
		// list.stream().forEach(System.out::println);
		list.stream().forEach(str -> Log.info("{}", str));

		String result = list.stream().collect(Collectors.joining("<br>"));

		String msg = "ex88_streamAPI 결과: <br>" + result;
		System.out.println(msg);
		return msg;
	}

	// 3-3-3. java for문 ===========================================
	public String ex89_for() {
		// 1. Integer 배열 생성 및 List 변환
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = Arrays.asList(integerArray); // Arrays.asList: 배열로부터 List 인터페이스 객체 생성
		List<Integer> evenList = new ArrayList<Integer>(); // 제네릭스<> 사용 >> 리스트의 타입 설정 >> String 들어가면 오류

		String result = "";

		// 2. for문 활용: 짝수 필터링
		for (int i = 0; i < list.size(); i++) {
			Integer number = list.get(i);
			if (number % 2 == 0) { // 2로 나눴을 때의 나머지가 0이면 2의 배수이다.
				evenList.add(number);
				result += number + "<br>";
			}
			// Log.info(result);
		}

		// 스트림 API를 사용하지 않은 짝수 필터링 >> for문
		for (int i = 0; i < evenList.size(); i++) {
			System.out.println(evenList.get(i));
		}

		String msg = "ex89_for문을 활용한 리스트 짝수값 필터링 결과:<br>" + result;
		System.out.println(msg);
		return msg;
	}

	// 3-3-4. java streamAPI - filter() ===========================================
	public String ex90_filter() {
		// 1. Integer 배열 생성 및 List 변환
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = Arrays.asList(integerArray); // Arrays.asList: 배열로부터 List 인터페이스 객체 생성

		// 2. streamAPI 활용: 짝수 필터링
		List<Integer> evenList = list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());

		// 짝수 리스트를 콘솔에 출력
		// evenList.stream().forEach(value -> System.out.println(value));
		evenList.stream().forEach(value -> Log.info("{}", value));

		// 짝수 리스트를 문자열로 변환
		String evenListStr = evenList.stream().map(String::valueOf).collect(Collectors.joining("<br>"));

		String msg = "ex90_streamAPI - filter()를 활용한 리스트 짝수값 필터링 결과:<br>" + evenListStr;
		System.out.println(msg);
		return msg;
	}

	// 3-3-5. java forEach() ===========================================
	public String ex91_forEach() {
		// 1. Integer 배열 생성 및 List 변환
		Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> list = Arrays.asList(integerArray);

		// 2. 리스트 내 모든 값 콘솔에 출력
		// list.stream().forEach(value -> System.out.println(value));
		list.stream().forEach(value -> Log.info("{}", value));

		// 3. 리스트 값을 문자열로 변환
		String listStr = list.stream().map(String::valueOf).collect(Collectors.joining("<br>"));

		String msg = "ex91_streamAPI - forEach()를 활용한 리스트값 출력 결과:<br>" + listStr;
		System.out.println(msg);
		return msg;
	}

	// 3-3-7. streamAPI - distinct() ===========================================
	public String ex93_distinct() {
		// 1. Integer 배열 생성 및 List 변환
		Integer[] integerArray = new Integer[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		List<Integer> list = Arrays.asList(integerArray);

		// 2. 중복을 제거(distinct)한 리스트 생성
		List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());

		// 3. 중복 제거된 리스트의 요소 콘솔에 출력
		// distinctList.stream().forEach(value -> System.out.println(value));
		distinctList.stream().forEach(value -> Log.info("{}", value));

		// 4. 중복 제거된 리스트를 문자열로 변환
		String distinctListStr = distinctList.stream().map(String::valueOf).collect(Collectors.joining("<br>"));

		String msg = "ex93_streamAPI - distinct()를 활용한 리스트 중복값 제거 결과:<br>" + distinctListStr;
		System.out.println(msg);
		return msg;
	}

	// 3-3-8. streamAPI - java map() ===========================================
	// 스트림의 각 요소에 대해 함수를 적용하여 새로운 스트림 생성 >> 요소 변환/형 변환
	public String ex93_map() {
		// 1. 소문자 문자열 배열 생성
		String[] lowercaseArray = new String[] { "public", "static", "void" };

		// 2. list로 변환
		List<String> lowercaseList = Arrays.asList(lowercaseArray);
		// 3. 모든 요소를 대문자로 변환한 list 생성
		List<String> uppercaseList = lowercaseList.stream().map(value -> value.toUpperCase())
				.collect(Collectors.toList());

		// 4. 대문자 변환 리스트 로그 출력
		uppercaseList.stream().forEach(value -> Log.info("{}", value));

		// 5. 각 리스트의 요소들을 문자열로 변환
		String lowercaseListStr = lowercaseList.stream().collect(Collectors.joining("<br>"));
		String uppercaseListStr = uppercaseList.stream().collect(Collectors.joining("<br>"));

		String msg = "ex93_map 결과:<br>=== 소문자 ===<br>" + lowercaseListStr + "<br>=== 대문자 ===<br>" + uppercaseListStr;
		System.out.println(msg);
		return msg;
	}

	// 3-3-9. ===========================================
	public String ex94_null() {
		// 1. 문자열을 가져오기 (null이 될 수 있음)
		String isThisNull = getSomeString();

		String result = null;

		// 2. 문자열이 null이 아닐 때만 변환
		if (null != isThisNull) {
			result = isThisNull.toUpperCase();
			Log.info("변환 결과: {}", result);
		} else {
			result = "null";
			Log.info("처리가 불가능한 null 문자열입니다.");
		}

		String msg = "ex94_null 결과: " + result;
		System.out.println(msg);
		return msg;
	}

	// getSomeString() 예제 구현 메소드 생성
	private String getSomeString() {
		// 1. 항상 null을 반환
		// return null;

		// 2. 특정 문자열 반환
		String str = "문자열이 null이 아닐 경우만 변환합니다.";
		return str;
	}

	// 3-3-11. java 비어 있는 optional 반환 ===========================================
	// optional: if문으로 null을 체크하는 코드 개선 가능
	public String ex95_optional() {

		// Optional이 값이 있을 때 로그 출력
		Optional<String> isThisNull = getSomeString2();
		isThisNull.ifPresent(str -> Log.info("반환 결과: {}", str)); // 값이 존재하지 않기 때문에 람다함수 실행X

		String msg = "ex95_optional 결과: " + isThisNull;
		System.out.println(msg);
		return msg;
	}

	private static Optional<String> getSomeString2() {
		return Optional.empty(); // null을 반환하는 것이 아니라, 비어 있는 Optional을 반환
	}

	// 3-3-13. 안티패턴 & 3-3-14. 안티패턴 해결 ===========================================
	// 비효율적이거나 생산적이지 않은 패턴
	public String ex97_optional() {
		Optional<String> str = getSomeString3();

		Optional<Object> result = null;

		// 3-3-13. isPresent() 메서드를 마치 if문처럼 잘못 사용
		// if (str.isPresent()) {
		// Log.info("{}", result);
		// }

		// 3-3-14. 안티 패턴 해결
		str.ifPresent((String) -> Log.info(String.toUpperCase()));

		String msg = "ex97_optional 결과: " + result;
		System.out.println(msg);
		return msg;
	}

	private static Optional<String> getSomeString3() {
		return Optional.ofNullable("public static void");
	}

}
