package com.rzagni.mastermind;


public class IntegerCodeMaker extends IntegerCoder {
	
	private final Peg<Integer>[] secretPattern;

	/**
	 * Creates a code maker that will create a secret pattern of the desired length,
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

	/**
	 * Evaluates the guess in respect to the secret pattern.
	 * Gives a BLACK ResultMarker for every Peg of the right color in the right position,
	 * and a WHITE peg for every Peg of the right color in the wrong position,
	 * Pattern and guess should be the same length, as well as the Result.
	 * @param pattern the pattern to be compared with the guess
	 * @param guess the guess to be compared with the pattern 
	 * @return the result of the evaluation
	 */
	public ResultMarker[] evaluateGuess(Peg<Integer>[] guess) {
		return evaluatePattern(this.secretPattern, guess);
	}

}
