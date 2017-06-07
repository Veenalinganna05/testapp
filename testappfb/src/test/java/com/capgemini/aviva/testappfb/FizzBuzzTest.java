package com.capgemini.aviva.testappfb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.aviva.testappfb.service.FizzBuzz;
import com.capgemini.aviva.testappfb.service.FizzBuzzImpl;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
public class FizzBuzzTest {
   
	private String expected ;
	
	
	private FizzBuzz fizzBuzz = new FizzBuzzImpl();
	
   /* @Test
    public void testForOne() {
    	Stream<Object> actual = fizzBuzz.printFizzBuzz(1);
      assertEquals(1, actual.findFirst().get());
    }

    
    @Test
    public void testForNumberRandom() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(9).collect(Collectors.toList());
           assertEquals(8, actual.get(7));
    }
    
    @Test
    public void testForFizz() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(7).collect(Collectors.toList());
    	
      assertEquals("Fizz", actual.get(2));
    }
    @Test
    public void testForBuzz() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(7).collect(Collectors.toList());
    	
      assertEquals("Buzz", actual.get(4));
    }
    @Test
    public void testForFizzBuzz() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(16).collect(Collectors.toList());
    	
      assertEquals("FizzBuzz", actual.get(14));
    }
    
    @Test
    public void testForGreaterThan1000() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(1001).collect(Collectors.toList());
    	
    	assertTrue( Optional.of(actual).isPresent());
    }
    
    @Test
    public void testForFizzLessThan1() {
    	List<Object> actual = fizzBuzz.printFizzBuzz(0).collect(Collectors.toList());
    	
    	 assertTrue( actual.isEmpty());
    }
   
    @After
    public void reset() {
        System.setOut(null);
    }*/
}
