package com.rzagni.mastermind;

public interface CodeBreaker<COLOR> {

	public abstract Peg<COLOR>[] getCurrentGuess();

	public abstract int getGuessCount();

	public abstract Peg<COLOR>[] getNextGuess(ResultMarker[] result);

}