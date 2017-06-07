package com.capgemini.aviva.testappfb.service;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzzImpl implements FizzBuzz{

	
	@Override
	public  String printFizzBuzz(int lastcount) {
		 StringBuffer bfr = new StringBuffer();
	    	  IntPredicate dividesBy3 = i -> i % 3 == 0;
	          IntPredicate dividesBy5 = i -> i % 5 == 0;
	          IntPredicate doesntDivide = dividesBy3.negate().and(dividesBy5.negate());

	          IntStream.rangeClosed(0, lastcount).forEach(i -> {
	             

	              if (dividesBy3.test(i)) bfr.append("Fizz");
	              if (dividesBy5.test(i)) bfr.append("Buzz");
	              if (doesntDivide.test(i)) bfr.append(i);

	              System.out.println(bfr);
	             
	      });
	          return bfr.toString();
			
	    
	}

	private   boolean isValidateCount(int lastcount) {
		return (lastcount >= 1 && lastcount <= 1000) ? true : false;
	}

}
