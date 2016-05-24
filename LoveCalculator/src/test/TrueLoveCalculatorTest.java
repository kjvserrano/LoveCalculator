package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveServer.TrueLoveCalculator;

public class TrueLoveCalculatorTest {
	TrueLoveCalculator trueLoveUUT = new TrueLoveCalculator();
	
	@Test
	public void trueCalculateTomShelly(){
		int res = trueLoveUUT.trueLoveCounter("Tom Thompson", "Shelly Smith", "true");
		assertEquals(4,res);
	}
	
	@Test
	public void loveCalculateTomShelly(){
		int res = trueLoveUUT.trueLoveCounter("Tom Thompson", "Shelly Smith", "love");
		assertEquals(6,res);
	}
	
	@Test
	public void trueCalculateJamesJane(){
		int res = trueLoveUUT.trueLoveCounter("James Smith", "John Doe", "true");
		assertEquals(3,res);
	}
	
	@Test
	public void loveCalculateJamesJane(){
		int res = trueLoveUUT.trueLoveCounter("James Smith", "John Doe", "love");
		assertEquals(4,res);
	}
	
	@Test
	public void trueLoveCalculateTomShelly(){
		String res = trueLoveUUT.calculate("Tom Thompson", "Shelly Smith");
		assertEquals("46% compatible",res);
	}
	
	@Test
	public void trueLoveCalculateJamesJane(){
		String res = trueLoveUUT.calculate("James Smith", "John Doe");
		assertEquals("34% compatible",res);
	}

}
