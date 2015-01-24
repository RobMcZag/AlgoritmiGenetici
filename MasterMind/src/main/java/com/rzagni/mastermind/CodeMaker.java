package com.rzagni.mastermind;

public interface CodeMaker<COLOR> {

	/**
	 * Evaluates the guess in respect to the secret pattern.
	 * Gives a BLACK ResultMarker for every Peg of the right color in the right position,
	 * and a WHITE peg for every Peg of the right color in the wrong position,
	 * Pattern and guess should be the same length, as well as the Result.
	 * @param pattern the pattern to be compared with the guess
	 * @param guess the guess to be compared with the pattern 
	 * @return the result of the evaluation
	 */
	public abstract ResultMarker[] evaluateGuess(Peg<COLOR>[] guess);

}