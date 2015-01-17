package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class PegCacheTest {

	public PegCacheTest() {
	}

	@Test
	public void testIntegerCacheCreation() {
		assertNotNull("Should be able to build a cache of Peg<Integer>", new PegCache<Integer>());
	}

	@Test
	public void testIntegerCacheGetPeg() {
		Integer color1 = 1;
		Peg<Integer> p1 = new Peg<Integer>(color1);
		
		PegCache<Integer> cache = new PegCache<Integer>();
		Peg<Integer> cachedP1 = cache.getPeg(color1);
		assertNotNull("the cache should return a real object", cachedP1);

		assertEquals("the cache should return a peg with the required color", p1, cachedP1);
		
		Peg<Integer> p1bis = cache.getPeg(1);
		assertEquals(cachedP1, p1bis);
		assertTrue("Cache should return always the same Peg for a certain colour", cachedP1 == p1bis);
	}


	@Test
	public void testEnumCacheCreation() {
		assertNotNull("Should be able to build a cache of Peg<ResultMarker>", new PegCache<ResultMarker>());
	}
	@Test
	public void testEnumCacheGetPeg() {
		
	}

	@Test
	public void testStringCacheCreation() {
		assertNotNull("Should be able to build a cache of Peg<String>", new PegCache<String>());
	}
}
