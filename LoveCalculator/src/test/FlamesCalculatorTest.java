package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveServer.FlamesCalculator;

public class FlamesCalculatorTest {
	FlamesCalculator flamesUUT = new FlamesCalculator();
	
	@Test
	public void flamesCalculatorLowerCase(){
		String result = flamesUUT.calculate("bob", "joe");
		assertEquals("Enemy", result);
	}
	
	@Test
	public void flamesCalculatorMixedCase(){
		String result = flamesUUT.calculate("Bob", "Joe");
		assertEquals("Enemy", result);
	}
	
	@Test
	public void flamesCalculatorNameWithSpace(){
		String result = flamesUUT.calculate("John Doe", "James Smith");
		assertEquals("Marriage", result);
	}
	
	@Test 
	public void flamesCalculatorZeroCount(){
		String result = flamesUUT.calculate("John Doe", "John Doe");
		assertEquals("Narcissist", result);
	}
	
}
