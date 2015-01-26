package com.rzagni.mastermind;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IntegerConsistentCodeBreakerTest {

	public IntegerConsistentCodeBreakerTest() {
	}

	@Test
	public void testIntegerConsistentCodeBreaker() {
		assertNotNull("Should be able to create object", new IntegerConsistentCodeBreaker(4, 6));
	}
	
	@Test
	public void testGenerateNextGuess() {
		IntegerConsistentCodeBreaker cb = new IntegerConsistentCodeBreaker(4, 6);
		Peg<Integer>[] firstGuess = cb.generateNextGuess(
				new ResultMarker[] {ResultMarker.EMPTY, ResultMarker.EMPTY, ResultMarker.EMPTY, ResultMarker.EMPTY});
		ResultMarker[] result = {ResultMarker.BLACK, ResultMarker.BLACK, ResultMarker.BLACK, ResultMarker.BLACK};
		Peg<Integer>[] secondGuess = cb.generateNextGuess(result);
		assertTrue("With all blacks the second guess should be equal to the first guess.", Arrays.equals(firstGuess, secondGuess));
	}

}
