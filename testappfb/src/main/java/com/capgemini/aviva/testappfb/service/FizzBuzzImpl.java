package com.capgemini.aviva.testappfb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzImpl implements FizzBuzz{

	
	@Override
	public  List<String> printFizzBuzz(int lastcount) {
		List<String> output = (List<String>) ((List<?>) IntStream
				.rangeClosed(1, lastcount).mapToObj(i -> {
					if (i % 3 == 0 && i % 5 != 0) {
						return "Fizz";
					} else if (i % 5 == 0 && i % 3 != 0) {
						return "Buzz";
					} else if (i % 5 == 0 && i % 3 == 0) {
						return "FizzBuzz";
					} else {
						return String.valueOf(i);
					}
				}).collect(Collectors.toCollection(ArrayList::new)));

		return output;
			
	    
	}

	private   boolean isValidateCount(int lastcount) {
		return (lastcount >= 1 && lastcount <= 1000) ? true : false;
	}

}
