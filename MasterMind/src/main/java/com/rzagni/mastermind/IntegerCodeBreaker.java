package com.rzagni.mastermind;

import java.util.ArrayList;
import java.util.List;

public class IntegerCodeBreaker extends IntegerCoder implements CodeBreaker<Integer>{
	
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
	}

	/**
	 * Generates and stores the next pattern for this codeBreaker.
	 * @param result 
	 */
	private Peg<Integer>[] generateNextGuess(ResultMarker[] result) {
		Peg<Integer>[] guess = generateRandomPattern();
		this.guesses.add(guess);
		return guess;
	}

	/* (non-Javadoc)
	 * @see com.rzagni.mastermind.CodeBreaker#getGuessCount()
	 */
	@Override
	public int getGuessCount() {
		return this.guesses.size();
	}

	/**
	 * Returns the list of guesses returned until now.
	 * @return the list of guesses returned until now.
	 */
	protected List<Peg<Integer>[]> getGuesses() {
		return this.guesses;
	}

	/* (non-Javadoc)
	 * @see com.rzagni.mastermind.CodeBreaker#getNextGuess(com.rzagni.mastermind.ResultMarker[])
	 */
	@Override
	public Peg<Integer>[]  getNextGuess(ResultMarker[] result) {
		if (result == null) {
			throw new IllegalArgumentException("The result can not be null.");
		}
		this.currentGuess = generateNextGuess(result);
		return this.currentGuess;
	}

}
