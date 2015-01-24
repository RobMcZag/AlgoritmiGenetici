package com.rzagni.mastermind;

public interface CodeBreaker<COLOR> {

	public abstract int getGuessCount();

	public abstract Peg<COLOR>[] getNextGuess(ResultMarker[] result);

}