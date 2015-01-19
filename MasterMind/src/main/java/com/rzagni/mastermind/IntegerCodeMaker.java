package com.rzagni.mastermind;


public class IntegerCodeMaker extends IntegerCoder {
	
	private final Peg<Integer>[] secretPattern;

	/**
	 * Creates a code maker that will create a pattern of the desired length,
	 * using the desired number of colors
	 * @param codeLength The desired length for the pattern. Minimum is 1.
	 * @param numberOfColors The desired number of colors to chose from to create the pattern. Minimum is 2.
	 * @throws IllegalArgumentException If arguments are below their allowed minimum.
	 */
	public IntegerCodeMaker(int codeLength, int numberOfColors) {
		super(codeLength, numberOfColors);
		this.secretPattern = generateRandomPattern();
	}

	public Peg<Integer>[] getSecretCode() {
		return this.secretPattern;
	}

}
