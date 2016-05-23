package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveClient.InputValidator;

public class InputValidatorTest {
	InputValidator inputValidatorUUT= new InputValidator();
	
	//Valid test
	@Test
	public void validInput() {
		assertTrue(inputValidatorUUT.validateInput("Bob,Joe"));
	}
	
	
	//Tests for different numbers of inputs
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
	
	//Tests for blank inputs
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
	
	
	//Tests for non-alphabetical inputs
	@Test
	public void numericalFirst() {
		assertFalse(inputValidatorUUT.validateInput("100,Bob"));
	}
	@Test
	public void numericalSecond() {
		assertFalse(inputValidatorUUT.validateInput("Bob,100"));
	}
	@Test
	public void punctuation() {
		assertFalse(inputValidatorUUT.validateInput("Bob!,100"));
	}

}
