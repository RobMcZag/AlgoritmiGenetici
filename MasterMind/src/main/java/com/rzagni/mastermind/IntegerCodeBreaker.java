package com.rzagni.mastermind;

public class IntegerCodeBreaker extends IntegerCoder{
	
	private Peg<Integer>[] currentGuess;
	private int guessCount;
			
	public IntegerCodeBreaker(int codeLength, int numberOfColors) {
		super(codeLength, numberOfColors);
		this.currentGuess = generateRandomPattern();
		this.guessCount = 1;
	}

	public Peg<Integer>[] getCurrentGuess() {
		return this.currentGuess;
	}

	public Object getGuessCount() {
		return this.guessCount;
	}

}
