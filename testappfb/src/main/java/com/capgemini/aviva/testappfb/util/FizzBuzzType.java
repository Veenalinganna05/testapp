package com.capgemini.aviva.testappfb.util;

public enum FizzBuzzType{

	THREE("Fizz"), FIVE("Buzz"), THREEFIVE("FizzBuzz");
	String value;
	FizzBuzzType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	protected void setValue(String value) {
		this.value = value;
	}

}
