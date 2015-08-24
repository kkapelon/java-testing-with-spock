package com.manning.spock.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplierTest {
	
	@Test
	public void simpleMultiplicationTest() 	{
		Multiplier multi = new Multiplier();
		assertEquals("3 times 7 is 21",21,multi.multiply(3, 7));
	}
	
	@Test
	public void combinedOperationsTest() {
		Adder adder = new Adder();
		Multiplier multi = new Multiplier();
		
		assertEquals("4 times (2 plus 3) is 20",20,multi.multiply(4, adder.add(2, 3)));
		assertEquals("(2 plus 3) times 4 is also 20",20,multi.multiply(adder.add(2, 3),4));
	}

}
