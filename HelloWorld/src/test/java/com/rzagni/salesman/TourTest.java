package com.rzagni.salesman;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TourTest {

	private City c1 ;
	private City c2 ;
	private City c3 ;
	private City c4 ;
	
	public TourTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new City(0, 0);
		c2 = new City(0, 20);
		c3 = new City(20, 0);
		c4 = new City(20, 20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canCreateAnEmptyTour() {
		Tour tour = new Tour(5);
		
		assertEquals(5, tour.numberOfCities());
		
		for (int i = 0; i < tour.numberOfCities(); i++) {
			assertNull(tour.getCity(i));
		}
	}

	@Test (expected = NullPointerException.class)
	public void noDistanceOnAnEmptyTour() {
		Tour tour = new Tour(5);
		assertEquals(0, tour.getTourDistance(), 0.001);
	}
	
	@Test
	public void canCreateATourFromDestinations() {
		ArrayList<City> destinations = new ArrayList<City>();
		destinations.add(c1);
		destinations.add(c2);
		destinations.add(c3);
		destinations.add(c4);
		
		
		Tour tour = new Tour(destinations);
		
		assertEquals(4, tour.numberOfCities());
		
		for (int i = 0; i < tour.numberOfCities(); i++) {
			assertNotNull(tour.getCity(i));
		}
		
		//
		assertEquals(20+Math.sqrt(20*20+20*20)+20, tour.getTourDistance(), 0.001);
	}
	
	@Test
	public void canPutAndGetBackCities() {
		Tour tour = new Tour(3);		
		tour.putCity(0, c1);
		tour.putCity(1, c2);
		tour.putCity(2, c3);
		
		assertEquals(c1, tour.getCity(0));
		assertEquals(c2, tour.getCity(1));
		assertEquals(c3, tour.getCity(2));
		
		tour.putCity(1, c4);
		assertEquals(c4, tour.getCity(1));
		
	}
}
