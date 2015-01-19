package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntegerCodeBreakerTest {

	private final int codeLength  = 4;
	private final int numberOfColors = 6;
	private IntegerCodeBreaker codeBreaker;

	public IntegerCodeBreakerTest() {
	}
	@Before
	public void setUp() throws Exception {
		codeBreaker = new IntegerCodeBreaker(codeLength, numberOfColors);
		
	}

	/* Fancy limit cases tested in super class IntegerCoder */
	@Test
	public void testCreationOfIntegerCodeBreaker() {
		assertNotNull("Should be able to create a real object.", codeBreaker);
		assertEquals("Code lenght should be the one passed.", codeLength, codeBreaker.getCodeLength() );
		assertEquals("Number of colors should be the one passed.", numberOfColors, codeBreaker.getNumberOfColors() );
	}

	@Test
	public void testGetCurrentGuess() {
		Peg<Integer>[] guess = codeBreaker.getCurrentGuess();
		assertNotNull("Should return a real pattern.", guess);
		assertEquals("Pattern lenght should be of the right length.", codeLength, guess.length);
		for (Peg<Integer> peg : guess) {
			assertNotNull("Peg in the secret code should not be null.", peg);
			assertTrue("Colors should be in the right range.", peg.getColor() >= 0 && peg.getColor() < numberOfColors);
		}
	}
	
	@Test
	public void testGetGuessCount() {
		assertEquals("Should return the count of the current guess.", 1, codeBreaker.getGuessCount());
		// TODO retrieve next guess and check guessCount advance
	}
	
	// TODO test getNextGuess(). Check length and Peg colors (like in testGetCurrentGuess() - REfactor checks)
}
