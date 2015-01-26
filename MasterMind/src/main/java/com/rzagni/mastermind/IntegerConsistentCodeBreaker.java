package com.rzagni.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerConsistentCodeBreaker extends IntegerCodeBreaker {

	private List<int[]> results = new ArrayList<int[]>();
	
	public IntegerConsistentCodeBreaker(int codeLength, int numberOfColors) {
		super(codeLength, numberOfColors);
	}

	/**
	 * Generates and stores the next guess for this codeBreaker.
	 * This CodeBreaker generates only guesses that are consistent with the previous guesses and their results.
	 * @param result the result obtained from the previous guess played from this CodeBreaker.
	 * @return the new guess to play, as an array of Pegs.
	 */
	@Override
	protected Peg<Integer>[] generateNextGuess(ResultMarker[] result) {
		if (getGuesses().size() > 0) {
			results.add(ResultMarker.countResultMarkers(result));
		}
		Peg<Integer>[] guess = null;
		boolean guessIsConsistent = false;
		while (! guessIsConsistent) {
			guess = generateRandomPattern();
			guessIsConsistent = true;
			for (int g = 0; g < getGuesses().size(); g++) {
				Peg<Integer>[] pastGuess = getGuesses().get(g);
				ResultMarker[] tempResult = evaluatePattern(pastGuess, guess);
				int[] tempResCount = ResultMarker.countResultMarkers(tempResult);
				if (! Arrays.equals(results.get(g), tempResCount)) {
					guessIsConsistent = false;
				}
			}
		}
		this.getGuesses().add(guess);
		return guess;
	}

}
