package com.rzagni.mastermind;

import java.util.HashMap;

/**
 * A simple cache of Pegs with a certain type of COLOR.
 * 
 * @author Roberto
 *
 * @param <COLOR> The type of COLOR desired for Pegs.  
 */
public class PegCache<COLOR> {

	private HashMap<COLOR, Peg<COLOR>> cache = new HashMap<COLOR, Peg<COLOR>>();
	
	synchronized public Peg<COLOR> getPeg(COLOR color) {
		Peg<COLOR> peg = cache.get(color);
		if (peg == null){
			peg = new Peg<COLOR>(color);
			cache.put(color, peg);
		}
		return peg;
	}

}
