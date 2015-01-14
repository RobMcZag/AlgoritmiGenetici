package com.rzagni.salesman;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityTest {

	public CityTest() {
	}

	@Test
	public void testDistance() {
		City c1 = new City(0, 0);
		City c2 = new City(0, 20);
		City c3 = new City(20, 0);
		City c4 = new City(20, 20);
		
		assertEquals(20, c1.distance(c2), 0.001);
		assertEquals(20, c1.distance(c3), 0.001);
		assertEquals(Math.sqrt(20*20+20*20), c1.distance(c4), 0.001);
	}

}
