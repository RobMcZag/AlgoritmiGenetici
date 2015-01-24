package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerCodeMakerTest {
	
	public IntegerCodeMakerTest() {
	}

	/* Fancy limit cases tested in super class IntegerCoder */
	@Test
	public void testIntegerCodeMakerCreation() {
		int lc = 4;
		int nc = 6;
		Coder codeMaker = new IntegerCodeMaker(lc, nc);
		assertNotNull("Should be able to create a new Code Maker", codeMaker);
		assertEquals("Code lenght should be the one passed", lc, codeMaker.getCodeLength() );
		assertEquals("Number of colors should be the one passed", nc, codeMaker.getNumberOfColors() );
	}

	@Test
	public void testGetPattern() {
		int lc = 4;
		int nc = 6;
		IntegerCodeMaker codeMaker = new IntegerCodeMaker(lc, nc);
		Peg<Integer>[] pattern = codeMaker.getSecretCode();
		assertNotNull("Should be able to get a real Code.", pattern);
		assertEquals("Code lenght should be the one passed.", lc, pattern.length );
		for (Peg<Integer> peg : pattern) {
			assertNotNull("Peg in the secret code should not be null.", peg);
			assertTrue("Colors should be in the right range", peg.getColor() >= 0 && peg.getColor() < nc);
		}
	}

}
