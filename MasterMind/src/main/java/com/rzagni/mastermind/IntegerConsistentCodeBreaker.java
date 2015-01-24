package com.rzagni.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerConsistentCodeBreaker extends IntegerCodeBreaker {

	private List<int[]> results = new ArrayList<int[]>();;
	
	public IntegerConsistentCodeBreaker(int codeLength, int numberOfColors) {
		super(codeLength, numberOfColors);
	}

	/**
	 * Generates and stores the next pattern for this codeBreaker.
	 * @param result 
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
				int[] pastResCount = results.get(g);
				if (! Arrays.equals(pastResCount, tempResCount)) {
					guessIsConsistent = false;
				}
			}
		}
		this.getGuesses().add(guess);
		return guess;
	}

}
