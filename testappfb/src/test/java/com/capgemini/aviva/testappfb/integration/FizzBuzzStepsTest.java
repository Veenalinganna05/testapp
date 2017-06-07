package com.capgemini.aviva.testappfb.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.aviva.testappfb.service.FizzBuzz;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FizzBuzzStepsTest {
	private List<Object> actual;
	private String result;
	
	@Autowired
	private FizzBuzz fizzBuzz;
	
	 @Given("^I provide the lastnumber (.+) to fizzbuzz$") 
	   public void i_provide_the_lastnumber_to_fizzbuzz(int intcount) { 
		 // actual = fizzBuzz.printFizzBuzz(9).collect(Collectors.toList()); 
	   } 
	 
	 
	 @When("^fizbuzz is printed$")
		public void fizbuzz_is_printed() {
			result = (String) actual.get(2);
		}
	 
	 @Then("fizzbuzz series is printed had (.+)$")
		public void fizzbuzz_series_is_printed_had(String fizz) {
		 assertThat(result, equalTo(fizz));
		}
}
