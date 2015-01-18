package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntegerCodeMakerTest {
	
	public IntegerCodeMakerTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCodeMakerCreation_ZeroLenght() {
		new IntegerCodeMaker(0, 6);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCodeMakerCreation_NegativeLenght() {
		new IntegerCodeMaker(-1, 6);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCodeMakerCreation_OneNumOfColors() {
		new IntegerCodeMaker(4, 1);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCodeMakerCreation_ZeroNumOfColors() {
		new IntegerCodeMaker(4, 0);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidIntegerCodeMakerCreation_NegativeNumOfColors() {
		new IntegerCodeMaker(4, -1);
		fail("Should thorw IllegalArgumentException in the statement before.");
	}
	
	@Test
	public void testIntegerCodeMakerCreation() {
		int lc = 4;
		int nc = 6;
		IntegerCodeMaker codeMaker = new IntegerCodeMaker(lc, nc);
		assertNotNull("Should be able to create a new Code Maker", codeMaker);
		assertEquals("Code lenght should be the one passed", lc, codeMaker.getCodeLength() );
		assertEquals("Number of colors should be the one passed", nc, codeMaker.getNumberOfColors() );
	}

	@Test
	public void testGetCode() {
		int lc = 4;
		int nc = 6;
		IntegerCodeMaker codeMaker = new IntegerCodeMaker(lc, nc);
		Peg<Integer>[] code = codeMaker.getSecretCode();
		assertNotNull("Should be able to get a real Code.", code);
		assertEquals("Code lenght should be the one passed.", lc, code.length );
		for (Peg<Integer> peg : code) {
			assertNotNull("Peg in the secret code should not be null.", peg);
			assertTrue("Colors should be in the right range", peg.getColor() >= 0 && peg.getColor() < nc);
		}
	}
		
	@Test
	public void testRandomnessOfCodes() {
		final int MAX_SCOSTAMENTO_PERC = 10;
		final int iterations = 100000;
		final int lc = 6;
		final int nc = 8;
		int[][] presenze = measureCodeGeneration(lc, nc,iterations);
		
		double pMed = iterations/ (double)nc;
		double pMin = pMed - (pMed * MAX_SCOSTAMENTO_PERC / 100D);
		double pMax = pMed + (pMed * MAX_SCOSTAMENTO_PERC / 100D);
		
		int[] totaleColore = new int[nc];
		for (int p = 0; p < lc; p++) {
			int totalePresenze = 0;
			for (int c = 0; c < nc; c++) {
//				System.out.print(presenze[p][c] + "|");
				totalePresenze += presenze[p][c];
				totaleColore[c] += presenze[p][c];
				assertTrue("For every color, the number of presences should be around the average",
						(presenze[p][c] >= pMin) && (presenze[p][c] <= pMax) );
			}
//			System.out.println();
			assertEquals("For every position, the totoal number of presence should be equal to the iterations",
					iterations, totalePresenze);
		}
//		System.out.println("--");
		
		for (int c = 0; c < nc; c++) {
//			System.out.print(totaleColore[c] + "|");
			assertTrue("For every color, the total number of presences should be around the average",
					(totaleColore[c] >= (pMin * lc)) && (totaleColore[c] <= (pMax * lc)) );
		}
//		System.out.println("\n");
	}

	/**
	 * @param lc
	 * @param nc
	 * @param presenze
	 * @param iterations
	 * @return 
	 */
	private int[][] measureCodeGeneration(int lc, int nc, int iterations) {
		int[][] presenze = new int[lc][nc];
		for (int i = 0; i < iterations; i++) {
			IntegerCodeMaker codeMaker = new IntegerCodeMaker(lc, nc);
			Peg<Integer>[] code = codeMaker.getSecretCode();
			for (int p = 0; p < code.length; p++) {
				Integer color = code[p].getColor();
				presenze[p][color]++;
			}
		}
		return presenze;
	}

}
