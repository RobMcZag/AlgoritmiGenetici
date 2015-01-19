package com.rzagni.mastermind;

public class IntegerCoder {

	protected static final int MIN_CODE_LENGTH = 1;
	protected static final int MIN_NUM_COLORS = 2;
	protected final int codeLength;
	protected final int numberOfColors;

	/**
	 * Creates a code maker that will create a code of the desired length,
	 * using the desired number of colors
	 * @param codeLength The desired length for the code. Minimum is 1.
	 * @param numberOfColors The desired number of colors to chose from to create the code. Minimum is 2.
	 * @throws IllegalArgumentException If arguments are below their allowed minimum.
	 */
	public IntegerCoder(int codeLength, int numberOfColors) {
		if (codeLength < MIN_CODE_LENGTH) {
			throw new IllegalArgumentException("The code length is below the minimum, that is " + MIN_CODE_LENGTH);
		}
		if (numberOfColors < MIN_NUM_COLORS) {
			throw new IllegalArgumentException("The number of colors is below the minimum, that is " + MIN_NUM_COLORS);
		}
		this.codeLength = codeLength;
		this.numberOfColors = numberOfColors;
	}

	public int getCodeLength() {
		return this.codeLength;
	}

	public int getNumberOfColors() {
		return this.numberOfColors;
	}

	/**
	 * Generates a random pattern of the current length and using Pegs of the allowed colors.
	 * @return an array with the generated Pegs;
	 */
	public Peg<Integer>[] generateRandomPattern() {
		@SuppressWarnings("unchecked")
		Peg<Integer>[] pattern = (Peg<Integer>[]) new Peg<?>[this.codeLength];
		for (int i = 0; i < pattern.length; i++) {
			java.util.Random r = new java.util.Random();
			Integer color = r.nextInt(this.numberOfColors);
			pattern[i] = PegFactory.getInstance().getPeg(color); 
		}
		return pattern;
	}

}