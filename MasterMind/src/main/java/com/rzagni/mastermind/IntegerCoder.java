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

	/**
	 * Evaluates the guess in respect to the pattern.
	 * Gives a BLACK ResultMarker for every Peg of the right color in the right position,
	 * and a WHITE peg for every Peg of the right color in the wrong position,
	 * Pattern and guess should be the same length, as well as the Result.
	 * @param pattern the pattern to be compared with the guess
	 * @param guess the guess to be compared with the pattern 
	 * @return the result of the evaluation
	 */
	public static ResultMarker[] evaluatePattern(
			Peg<Integer>[] pattern, Peg<Integer>[] guess) {
		
		if(pattern == null || guess == null) {
			throw new NullPointerException("Arguments pattern and guess can not be null.");
		}
		if(pattern.length != guess.length) {
			throw new IllegalArgumentException("Argument have different length. They should be the same length.");
		}
		ResultMarker[] result = new ResultMarker[pattern.length];
		
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == pattern[i]) {
				result[i] = ResultMarker.BLACK;
				continue;
			}
			for (int j = 0; j < pattern.length; j++) {
				if (guess[i] == pattern[j]) {
					result[i] = ResultMarker.WHITE;
					break;
				}
			}
			result[i] = ResultMarker.EMPTY;
		}
		// XXX should shuffle the array ?	java.util.Collections.shuffle(Arrays.asList(result));
		return result;
	}

}