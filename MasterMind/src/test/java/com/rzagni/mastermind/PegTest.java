package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class PegTest {

	public PegTest() {
	}

	@Test
	public void testIntegerPegCreation() {
		Integer color = 1;
		Peg<Integer> p = new Peg<Integer>(color);
		assertNotNull(p);
		assertEquals(color, p.getColor());
	}
	
	@Test
	public void testStringPegCreation() {
		String color = "R";
		Peg<String> p = new Peg<String>(color);
		assertNotNull(p);
		assertEquals(color, p.getColor());
	}
	
	@Test
	public void testEnumPegCreation() {
		ResultMarker color = ResultMarker.WHITE;
		Peg<ResultMarker> p = new Peg<ResultMarker>(color);
		assertNotNull(p);
		assertEquals(color, p.getColor());
	}
//	/**
//	 * Color has to be greater or equal to zero
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testIllegalPegCreation() {
//		Peg p = new Peg(-1);
//		fail();
//	}
//	// TODO test for negative colors => IllegalArg
}
