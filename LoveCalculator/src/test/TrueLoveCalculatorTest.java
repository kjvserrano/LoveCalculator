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

}
