package com.capgemini.aviva.testappfb.service;

import java.util.List;

public interface FizzBuzz {
	
	public List<String> printFizzBuzz(int lastcount);
	public   boolean isValidateCount(int lastcount);
	public   List<String> printFizzBuzzDay(int lastcount);
	public List<String> printFizzBuzzDay(int lastcount, CharSequence date);
	

}
