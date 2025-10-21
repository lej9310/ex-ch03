package com.lej.calculator.dto;

//record: 변수와 접근성(getter 메서드)만을 필요로 하는 단순하고 불변인 데이터 클래스를 선언하는데 적합
//레코드: 단순 선언만으로 필요한 모든 메서드들 자동 제공 <> 클래스: 필요한 모든 메서드를 수동으로 작성 
public record CalculatorResponse(double num1, double num2, String operation, String result) {

}
