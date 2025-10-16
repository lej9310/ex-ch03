package com.lej.calculator2.dto;

public record CalculatorResponse2(double num1, double num2, String operation, double result) {

	public double getNum1() {
		return num1;
	}

	public double getNum2() {
		return num2;
	}

	public String getOperation() {
		return operation;
	}

	public double getResult() {
		return result;
	}

}
