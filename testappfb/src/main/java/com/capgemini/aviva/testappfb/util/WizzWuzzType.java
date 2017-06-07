package com.capgemini.aviva.testappfb.util;

public enum WizzWuzzType {
	THREE("Wizz"), FIVE("Wuzz"),THREEFIVE("WizzBuzz");
	String value;
	WizzWuzzType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	protected void setValue(String value) {
		this.value = value;
	}

}
