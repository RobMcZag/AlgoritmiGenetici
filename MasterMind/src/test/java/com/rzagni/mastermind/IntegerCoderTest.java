package com.rzagni.mastermind;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IntegerCoderTest {

	private final Peg<Integer> peg0 = PegFactory.getInstance().getPeg(0);
	private final Peg<Integer> peg1 = PegFactory.getInstance().getPeg(1);
	private final Peg<Integer> peg2 = PegFactory.getInstance().getPeg(2);
	private final Peg<Integer> peg3 = PegFactory.getInstance().getPeg(3);
	private final Peg<Integer> peg4 = PegFactory.getInstance().getPeg(4);
	private final Peg<Integer> peg5 = PegFactory.getInstance().getPeg(5);

	public IntegerCoderTest() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCoderCreation_ZeroLenght() {
		new IntegerCoder(0, 6);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCoderCreation_NegativeLenght() {
		new IntegerCoder(-1, 6);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCoderCreation_OneNumOfColors() {
		new IntegerCoder(4, 1);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCoderCreation_ZeroNumOfColors() {
		new IntegerCoder(4, 0);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCoderCreation_NegativeNumOfColors() {
		new IntegerCoder(4, -1);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	
	@Test
	public void testIntegerCoderCreation() {
		int lc = 4;
		int nc = 6;
		IntegerCoder coder = new IntegerCoder(lc, nc);
		assertNotNull("Should be able to create a new Code Maker", coder);
		assertEquals("Code lenght should be the one passed", lc, coder.getCodeLength() );
		assertEquals("Number of colors should be the one passed", nc, coder.getNumberOfColors() );
	}


	@Test
	public void testRandomnessOfPatterns() {
		final int MAX_SCOSTAMENTO_PERC = 10;
		final int iterations = 100000;
		final int lc = 6;
		final int nc = 8;
		int[][] presenze = measurePatternGeneration(lc, nc,iterations);
		
		double pMed = iterations/ (double)nc;
		double pMin = pMed - (pMed * MAX_SCOSTAMENTO_PERC / 100D);
		double pMax = pMed + (pMed * MAX_SCOSTAMENTO_PERC / 100D);
		
		int[] totaleColore = new int[nc];
		for (int p = 0; p < lc; p++) {
			int totalePresenze = 0;
			for (int c = 0; c < nc; c++) {
				totalePresenze += presenze[p][c];
				totaleColore[c] += presenze[p][c];
				assertTrue("For every color, the number of presences should be around the average",
						(presenze[p][c] >= pMin) && (presenze[p][c] <= pMax) );
			}
			assertEquals("For every position, the total number of presence should be exactly equal to the iterations",
					iterations, totalePresenze);
		}
		
		for (int c = 0; c < nc; c++) {
			assertTrue("For every color, the total number of presences should be around the average",
					(totaleColore[c] >= (pMin * lc)) && (totaleColore[c] <= (pMax * lc)) );
		}
	}

	/**
	 * Creates the required number of CodeMakers and measure the coo of the Pegs found in their codes.
	 * @param lc the length of the code
	 * @param nc the number of colors to use
	 * @param iterations the number of codes to measure
	 * @return a matrix int[lc][nc] with the number of peg for any color in any position.
	 */
	private int[][] measurePatternGeneration(int lc, int nc, int iterations) {
		int[][] presenze = new int[lc][nc];
		IntegerCoder coder = new IntegerCoder(lc, nc);
		for (int i = 0; i < iterations; i++) {
			Peg<Integer>[] pattern = coder.generateRandomPattern();
			for (int p = 0; p < pattern.length; p++) {
				Integer color = pattern[p].getColor();
				presenze[p][color]++;
			}
		}
		return presenze;
	}

	@SuppressWarnings("unchecked")
	@Test(expected=NullPointerException.class)
	public void testEvaluatePattern_NullPattern() {
		Peg<Integer>[] guess =  (Peg<Integer>[]) new Peg<?>[3]; 
		IntegerCoder.evaluatePattern(null, guess);
		fail("A null pattern should generate a NullPointerException");
	}
	@SuppressWarnings("unchecked")
	@Test(expected=NullPointerException.class)
	public void testEvaluatePattern_NullGuess() {
		Peg<Integer>[] secretPattern =  (Peg<Integer>[]) new Peg<?>[4]; 
		IntegerCoder.evaluatePattern(secretPattern, null);
		fail("A null guess should generate a NullPointerException");
	}
	@SuppressWarnings("unchecked")
	@Test(expected=IllegalArgumentException.class)
	public void testEvaluatePattern_DifferentLength() {
		Peg<Integer>[] secretPattern =  (Peg<Integer>[]) new Peg<?>[4]; 
		Peg<Integer>[] guess =  (Peg<Integer>[]) new Peg<?>[3]; 
		IntegerCoder.evaluatePattern(secretPattern, guess);
		fail("Different sizes should generate an IllegalArgumentException");
	}
	
	private boolean checkResult(ResultMarker[] result, int blacks, int whites, int empties) {
		int b=0, w=0, e=0;
		for (ResultMarker resultMarker : result) {
			switch (resultMarker) {
			case EMPTY:
				e++;
				break;
			case WHITE:
				w++;
				break;
			case BLACK:
				b++;
				break;
			default:
				break;
			}
		}
		return ( b == blacks && w == whites && e == empties);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testEvaluatePattern() {
		int lc = 4;
		
		// [ 1, 2, 3, 4]
		Peg<Integer>[] secretPattern =  (Peg<Integer>[]) new Peg<?>[]{peg1, peg2, peg3, peg4}; 

		Peg<Integer>[] guess =  (Peg<Integer>[]) new Peg<?>[lc]; 

		// [1, 2, 3, 4] VS [0, 2, 3, 4] => [ E, B, B, B ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg0, peg2, peg3, peg4}; 
		ResultMarker[] result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 3, 0, 1) );
		
		// [1, 2, 3, 4] VS [0, 2, 0, 0] => [ E, B, E, E ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg0, peg2, peg0, peg0}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 1, 0, 3) );

		// [1, 2, 3, 4] VS [5, 5, 5, 5] => [ E, E, E, E ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg5, peg5, peg5, peg5}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 0, 0, 4) );

		// [1, 2, 3, 4] VS [3, 3, 3, 3] => [ E, E, B, E ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg3, peg3, peg3, peg3}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 1, 0, 3) );

		// [1, 2, 3, 4] VS [3, 3, 4, 4] => [ E, E, W, B ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg3, peg3, peg4, peg4}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 1, 1, 2) );

		// [1, 2, 3, 4] VS [3, 2, 2, 4] => [ E, B, W, B ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg3, peg2, peg2, peg4}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 2, 1, 1) );

		// [1, 2, 3, 4] VS [0, 3, 3, 4] => [ E, E, B, B ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg0, peg3, peg3, peg4}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 2, 0, 2) );

		// [1, 2, 3, 4] VS [0, 3, 3, 2] => [ E, E, B, W ]

		// [ 1, 2, 2, 4]
		secretPattern =  (Peg<Integer>[]) new Peg<?>[] {peg1, peg2, peg2, peg4}; 

		// [1, 2, 2, 4] VS [2, 2, 1, 3] => [ W, B, W, E ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg2, peg2, peg1, peg3}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 1, 2, 1) );

		// [1, 2, 2, 4] VS [2, 1, 4, 2] => [ W, W, W, W ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg2, peg1, peg4, peg2}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 0, 4, 0) );

		// [1, 2, 2, 4] VS [1, 2, 2, 4] => [ B, B, B, B ]
		guess =  (Peg<Integer>[]) new Peg<?>[] {peg1, peg2, peg2, peg4}; 
		result = IntegerCoder.evaluatePattern(secretPattern, guess);
		checkThisIsARealResultArray(result, secretPattern.length);
		assertTrue("The result should be correct. Result is:" + Arrays.toString(result), checkResult(result, 4, 0, 0) );

	}

	/**
	 * Checks the passed ResultMarker array is a real array with real ResultMarkers in all positions
	 * @param result
	 */
	private void checkThisIsARealResultArray(ResultMarker[] result, int lc) {
		assertNotNull("Should return a real result, not null.", result);
		assertEquals("Pattern lenght should be of the right length.", lc, result.length);
		for (ResultMarker marker : result) {
			assertNotNull("Marker in the result should not be null.", marker);
			assertTrue("Result should be one of the right values: black, white or empty", 
					marker == ResultMarker.BLACK || marker == ResultMarker.EMPTY || marker == ResultMarker.WHITE);
		}
	}
	
}
