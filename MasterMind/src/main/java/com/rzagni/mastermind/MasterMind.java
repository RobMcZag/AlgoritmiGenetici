package com.rzagni.mastermind;

import java.util.Arrays;

public class MasterMind {

	public static void main(String[] args) {
		int codeLength = 4;
		int numberOfColors = 6;
		IntegerCodeMaker cm = new IntegerCodeMaker( codeLength, numberOfColors);
		IntegerCodeBreaker cb = new IntegerCodeBreaker(codeLength, numberOfColors);
		
		int[] res = new int[ResultMarker.values().length];
		ResultMarker[] result = new ResultMarker[codeLength];
		Arrays.fill(result, ResultMarker.EMPTY);
		int guessCounter = 0;
		while (res[ResultMarker.BLACK.ordinal()] < codeLength) {
			Peg<Integer>[] guess = cb.getNextGuess(result);
			result = cm.evaluateGuess(guess);
			res = ResultMarker.countResultMarkers(result);
			logInfo(++guessCounter);
		}
		System.out.println("\nSoluzione trovata in " + guessCounter + " tentativi");
	}

	private static void logInfo(int guessCounter) {
		System.out.print(".");
		if ((guessCounter % 50) == 0) {
			System.out.println(" - " + guessCounter);
		}
	}

}
