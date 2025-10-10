package com.example.demo.service;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	private static final Logger Log = LoggerFactory.getLogger(MyService.class);

	public String sayhello(String hi) {
		String msg = hi + ", 좋은 하루~!";
		System.out.println(msg);
		Log.info(msg);

		return msg;
	}

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

		System.out.println(result);
		Log.info(result);

		String msg = "ex70_str 결과: " + result;
		return msg;
	}

	public Integer ex70_int() {
		Log.info("999");
		return 999;
	}

	public String ex72_for() {
		int[] array = { 1, 2, 3, 4, 5 };
		String result = "";

		for (int i = 0; i < array.length; i++) {
			String currentResult = "i = " + array[i];
			result += currentResult + "\n";

			System.out.println(currentResult);
			Log.info(currentResult);
		}

		String msg = "ex72_for 결과: " + result;
		return msg;
	}

	public String ex73_while() {
		StringBuilder stringBuilder = new StringBuilder();
		int[] array = { 1, 2, 3, 4, 5 };
		int i = 0;

		while (i < array.length) {
			String currentResult = "i = " + array[i];
			stringBuilder.append(currentResult);

			Log.info(currentResult);
			i++;
		}

		String msg = "ex73_while 결과: " + stringBuilder.toString();
		return msg;
	}

	public String ex78_ArrList() {
		
		return null;
	}

}
