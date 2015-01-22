package com.rzagni.mastermind;

import java.util.ArrayList;
import java.util.List;

public class IntegerCodeBreaker extends IntegerCoder{
	
	private Peg<Integer>[] currentGuess;
	private final List<Peg<Integer>[]> guesses = new ArrayList<Peg<Integer>[]>();;
//	private List<ResultMarker[]> results;
			
	/**
	 * Creates a CodeBreaker to play with codes of the required length and number of colors.
	 * @param codeLength The length of the code to be guessed;
	 * @param numberOfColors The number of colors allowed into the code;
	 */
	public IntegerCodeBreaker(int codeLength, int numberOfColors) {
		super(codeLength, numberOfColors);
		generateNextPattern();
	}

	/**
	 * Generates and stores the next pattern for this codeBreaker.
	 */
	private Peg<Integer>[] generateNextPattern() {
		this.currentGuess = generateRandomPattern();
		this.guesses.add(currentGuess);
		return this.currentGuess;
	}

	public Peg<Integer>[] getCurrentGuess() {
		return this.currentGuess;
	}

	public int getGuessCount() {
		return this.guesses.size();
	}

	public Peg<Integer>[]  getNextGuess(ResultMarker[] result) {
		if (result == null) {
			throw new IllegalArgumentException("The result can not be null.");
		}
		return generateNextPattern();
	}

}
