package com.capgemini.aviva.testappfb.util;

import java.time.DayOfWeek;

public final class BuzzType {
	
	public BuzzType(String threeBuzz, String fiveVuzz, String threthreeFiveBuzz) {
		super();
		this.threeBuzz = threeBuzz;
		this.fiveVuzz = fiveVuzz;
		this.threthreeFiveBuzz = threthreeFiveBuzz;
	}



	private final String  threeBuzz;
	public String getThreeBuzz() {
		return threeBuzz;
	}



	public String getFiveVuzz() {
		return fiveVuzz;
	}



	public String getThrethreeFiveBuzz() {
		return threthreeFiveBuzz;
	}



	private final String fiveVuzz;
	private final String threthreeFiveBuzz;
	
	
	
	public static final  BuzzType getbuzzType(DayOfWeek dayOfWeek){
		if(dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) == 0){
			return new BuzzType(WizzWuzzType.THREE.getValue(),WizzWuzzType.FIVE.getValue(),
					WizzWuzzType.THREEFIVE.getValue());
		}else
			{
		return  new BuzzType(FizzBuzzType.THREE.getValue(),FizzBuzzType.FIVE.getValue(),
				FizzBuzzType.THREEFIVE.getValue());
	}
	}


	
	

}
