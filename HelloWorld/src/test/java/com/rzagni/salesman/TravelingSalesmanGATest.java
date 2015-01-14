package com.rzagni.salesman;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TravelingSalesmanGATest {

	public TravelingSalesmanGATest() {
	}

	@Test
	public void generateTheIntendedNumberOfCities() {
		int numCities = 20;
		List<City> destinations = TravelingSalesmanGA.generateRandomCities(numCities);
		
		assertEquals(numCities, destinations.size());
		
	}

}
