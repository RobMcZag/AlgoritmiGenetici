package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerCoderTest {

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

}
