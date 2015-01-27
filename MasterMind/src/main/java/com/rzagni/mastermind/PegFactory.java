package com.rzagni.mastermind;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory objects to build pegs of a certain type.
 * @author Roberto
 *
 */
public class PegFactory {
	
	private static final PegFactory instance = new PegFactory(); 
	
	private PegFactory() {
	}
	
	/**
	 * Returns the only instance allowed for the factory
	 * @return the instance
	 */
	public static PegFactory getInstance() {
		return instance;
	}

	@SuppressWarnings("rawtypes")
	private final Map<Class, PegCache> instanceMap = new HashMap<Class, PegCache>();

	public <COLOR> Peg<COLOR> getPeg(COLOR color) {
		@SuppressWarnings("unchecked")
		PegCache<COLOR> cache = (PegCache<COLOR>) getCache(color.getClass());
		return cache.getPeg(color);
	}

	@SuppressWarnings("unchecked")
	synchronized private <COLOR> PegCache<COLOR> getCache(Class<COLOR> clazz) {
		if (instanceMap.containsKey(clazz)) {
			return (PegCache<COLOR>) instanceMap.get(clazz);
		} 
		PegCache<COLOR> cache = new PegCache<COLOR>();
		instanceMap.put(clazz, cache);
		return cache;
	}
}
