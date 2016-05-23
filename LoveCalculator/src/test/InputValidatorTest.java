package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveClient.InputValidator;

public class InputValidatorTest {
	InputValidator inputValidatorUUT= new InputValidator();
	
	@Test
	public void validInput() {
		assertTrue(inputValidatorUUT.validateInput("Bob,Joe"));
	}
	
	@Test
	public void noInput() {
		assertFalse(inputValidatorUUT.validateInput(""));
	}
	
	@Test
	public void oneInput() {
		assertFalse(inputValidatorUUT.validateInput("Bob"));
	}
	
	@Test
	public void threeInputs() {
		assertFalse(inputValidatorUUT.validateInput("Bob,Joe,Ann"));
	}
	
	@Test
	public void oneComma() {
		assertFalse(inputValidatorUUT.validateInput(","));
	}
	
	@Test
	public void commaOneInputAfter() {
		assertFalse(inputValidatorUUT.validateInput(",Bob"));
	}
	
	@Test
	public void commaOneInputBefore() {
		assertFalse(inputValidatorUUT.validateInput("Bob,"));
	}

}
