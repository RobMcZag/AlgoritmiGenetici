package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntegerCodeBreakerTest {

	private final int codeLength  = 4;
	private final int numberOfColors = 6;
	private IntegerCodeBreaker codeBreaker;
	private final ResultMarker[] result = { ResultMarker.BLACK, ResultMarker.BLACK, ResultMarker.BLACK, ResultMarker.EMPTY };

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
		checkThisIsARealPegArray(guess);
	}
	/**
	 * Checks the passed peg array is a real array with real pegs in all positions
	 * @param guess
	 */
	private void checkThisIsARealPegArray(Peg<Integer>[] guess) {
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
		codeBreaker.getNextGuess(result);
		assertEquals("Should return the count of the current guess.", 2, codeBreaker.getGuessCount());
		codeBreaker.getNextGuess(result);
		assertEquals("Should return the count of the current guess.", 3, codeBreaker.getGuessCount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetNextGuess_NullResult() {
		codeBreaker.getNextGuess(null);
		fail("Should throw an IllegalArgumentException");
	}
	
	@Test
	public void testGetNextGuess() {
		Peg<Integer>[] guess = codeBreaker.getCurrentGuess();
		Peg<Integer>[] nextGuess = codeBreaker.getNextGuess(result);
		checkThisIsARealPegArray(nextGuess);
	}
	// TODO should we remember and return guesses and results to every guess?
	
}
