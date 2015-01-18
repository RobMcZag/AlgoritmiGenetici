package com.rzagni.mastermind;

public class IntegerCodeMaker {
	
	private static final int MIN_CODE_LENGTH = 1;
	private static final int MIN_NUM_COLORS = 2;
	
	private final int codeLength;
	private final int numberOfColors;
	private final Peg<Integer>[] secretCode;

	/**
	 * Creates a code maker that will create a code of the desired length,
	 * using the desired number of colors
	 * @param codeLength The desired length for the code. Minimum is 1.
	 * @param numberOfColors The desired number of colors to chose from to create the code. Minimum is 2.
	 * @throws IllegalArgumentException If arguments are below their allowed minimum.
	 */
	public IntegerCodeMaker(int codeLength, int numberOfColors) {
		if (codeLength < MIN_CODE_LENGTH) {
			throw new IllegalArgumentException("The code length is below the minimum, that is " + MIN_CODE_LENGTH);
		}
		if (numberOfColors < MIN_NUM_COLORS) {
			throw new IllegalArgumentException("The number of colors is below the minimum, that is " + MIN_NUM_COLORS);
		}
		this.codeLength = codeLength;
		this.numberOfColors = numberOfColors;
		this.secretCode = generateSecretCode();
	}

	/**
	 * Generates a secret code of the current length and using Pegs of the allowed colors
	 * @return an array with the generated Pegs;
	 */
	@SuppressWarnings("unchecked")
	private Peg<Integer>[] generateSecretCode() {
		Peg<Integer>[] secretCode = new Peg[this.codeLength];
		for (int i = 0; i < secretCode.length; i++) {
			java.util.Random r = new java.util.Random();
			Integer color = r.nextInt(this.numberOfColors);
			secretCode[i] = PegFactory.getInstance().getPeg(color); 
		}
		return secretCode;
	}

	public int getCodeLength() {
		return this.codeLength;
	}

	public int getNumberOfColors() {
		return this.numberOfColors;
	}

	public Peg<Integer>[] getSecretCode() {
		return this.secretCode;
	}

}
