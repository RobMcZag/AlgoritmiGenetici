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

	/** 
	 * Two pegs are equal if they have the same color.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Peg<?>) {
			return this.color.equals(((Peg<?>) obj).getColor());
		}
		return false;
	}

	/**
	 * Two pegs are equal if they have the same color, 
	 * so they should have the same hashCode if are of the same color.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.color.hashCode();
	}
	
	@Override
	public String toString() {
		return this.color.toString();
	}
	
}
