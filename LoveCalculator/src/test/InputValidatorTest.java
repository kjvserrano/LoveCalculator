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

}
