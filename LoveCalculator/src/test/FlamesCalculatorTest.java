package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.loveServer.FlamesCalculator;

public class FlamesCalculatorTest {
	FlamesCalculator flamesUUT = new FlamesCalculator();
	
	//FlamesCountTest
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
	@Test
	public void flamesCountSpace(){
		int flamesCount = flamesUUT.flamesCount("Bobby Jones", "Steve Jobs");//"yn", "tv"
		assertEquals(4,flamesCount);
	}
	@Test
	public void flamesCountZero(){
		int flamesCount = flamesUUT.flamesCount("Bobby Jones", "Bobby Jones");
		assertEquals(0,flamesCount);
	}
	
	//FlamesResult
	/*
	1 = S
	2 = E
	3 = F
	4 = E
	5 = F
	6 = M
	7 = E
	8 = A
	9 = E
	*/
	@Test
	public void flamesResultOne(){
		char result = flamesUUT.flamesResult(1);
		assertEquals('s',result);
	}
	
	@Test
	public void flamesResultThree(){
		char result = flamesUUT.flamesResult(3);//F
		assertEquals('f',result);
	}
	
	@Test
	public void flamesResultSix(){
		char result = flamesUUT.flamesResult(6);//F
		assertEquals('m',result);
	}
	
	@Test
	public void flamesResultNine(){
		char result = flamesUUT.flamesResult(9);//F
		assertEquals('e',result);
	}

	@Test
	public void flamesResultZero(){
		char result = flamesUUT.flamesResult(0);//N
		assertEquals('n',result);
	}
}
