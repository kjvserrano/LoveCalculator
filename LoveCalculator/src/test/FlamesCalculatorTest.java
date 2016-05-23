package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveServer.FlamesCalculator;

public class FlamesCalculatorTest {
	FlamesCalculator flamesUUT = new FlamesCalculator();
	
	@Test
	public void flamesCountLowerCase(){
		int flamesCount = flamesUUT.flamesCount("bob", "joe");
		assertEquals(4,flamesCount);
	}
	@Test
	public void flamesCountUpperLowerCase(){
		int flamesCount = flamesUUT.flamesCount("Bobby", "Jobs");
		assertEquals(3,flamesCount);
	}

}
