package com.rzagni.mastermind;

/**
 * Implements a basic peg in the MasterMind game.
 * A peg has one color, fixed at creation, of the desired type.
 * Colors can be of any type: integers, strings or color enumerations.
 * @author Roberto
 *
 */
public class Peg<COLOR> {

	private COLOR color;

	public Peg(COLOR color) {
		this.color = color;
	}

	public COLOR getColor() {
		return this.color;
	}
	
	
}
