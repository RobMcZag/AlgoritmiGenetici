package com.rzagni.salesman;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.uncommons.maths.random.MersenneTwisterRNG;

public class TourSwapMutationTest {

	private City c1 ;
	private City c2 ;
	private City c3 ;
	private City c4 ;

	public TourSwapMutationTest() {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new City(0, 0);
		c2 = new City(0, 20);
		c3 = new City(20, 0);
		c4 = new City(20, 20);
	}

	@Test
	public void applyShouldGenerateAnEvolvedTourDistinctFromSelectedTour() {
		ArrayList<City> destinations = new ArrayList<City>();
		destinations.add(c1);
		destinations.add(c2);
		destinations.add(c3);
		destinations.add(c4);
		Tour tour = new Tour(destinations);

		TourSwapMutation tsm = new TourSwapMutation();
		Tour evolvedTour = tsm.apply(Arrays.asList(tour), new MersenneTwisterRNG()).get(0);
		assertNotEquals(tour, evolvedTour);
//		System.out.println(tour);
//		System.out.println(evolvedTour);
	}

}
