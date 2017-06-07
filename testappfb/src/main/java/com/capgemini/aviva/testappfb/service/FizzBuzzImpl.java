package com.capgemini.aviva.testappfb.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.capgemini.aviva.testappfb.util.BuzzType;

public class FizzBuzzImpl implements FizzBuzz{

	
	
	public   List<String> printFizzBuzz(int lastcount) {
		return  IntStream
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
				}).collect(Collectors.toCollection(ArrayList::new));

					
	    
	}
	public   List<String> printFizzBuzzDay(int lastcount, CharSequence date) {
		LocalDate currentDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yy"));
		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		BuzzType buzzValueType = BuzzType.getbuzzType(dayOfWeek);
		return  IntStream
				.rangeClosed(1, lastcount).mapToObj(i -> {
					if (i % 3 == 0 && i % 5 != 0) {
						return buzzValueType.getThreeBuzz();
					} else if (i % 5 == 0 && i % 3 != 0) {
						return buzzValueType.getFiveVuzz();
					} else if (i % 5 == 0 && i % 3 == 0) {
						return buzzValueType.getThrethreeFiveBuzz();
					} else {
						return String.valueOf(i);
					}
				}).collect(Collectors.toCollection(ArrayList::new));

					
	    
	}
	
	public   List<String> printFizzBuzzDay(int lastcount) {
		LocalDate currentDate = LocalDate.now();
		DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
		BuzzType buzzValueType = BuzzType.getbuzzType(dayOfWeek);
		return  IntStream
				.rangeClosed(1, lastcount).mapToObj(i -> {
					if (i % 3 == 0 && i % 5 != 0) {
						return buzzValueType.getThreeBuzz();
					} else if (i % 5 == 0 && i % 3 != 0) {
						return buzzValueType.getFiveVuzz();
					} else if (i % 5 == 0 && i % 3 == 0) {
						return buzzValueType.getThrethreeFiveBuzz();
					} else {
						return String.valueOf(i);
					}
				}).collect(Collectors.toCollection(ArrayList::new));

					
	    
	}

	public   boolean isValidateCount(int lastcount) {
		return (lastcount >= 1 && lastcount <= 1000) ? true : false;
	}

}
