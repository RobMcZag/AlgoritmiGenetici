package com.rzagni.mastermind;

public interface Coder<COLOR> {

	public abstract int getCodeLength();

	public abstract int getNumberOfColors();

	/**
	 * Generates a random pattern of the current length and using Pegs of the allowed colors.
	 * @return an array with the generated Pegs;
	 */
	public abstract Peg<COLOR>[] generateRandomPattern();

}