package com.rzagni.salesman;

import java.util.Arrays;
import java.util.List;


/**
 * The class representing a potential solution to visit all the city in the destination list
 * @author Roberto
 *
 */
public class Tour {
	
	private final City[] tour;
	
	public Tour(int lenght) {
		this.tour = new City[lenght];
	}
	
	public Tour(List<City> destinations) {
		this(destinations.size());
		int index=0;
		for (City city : destinations) {
			putCity(index++, city);
		}
	}	
	
	public List<City> getDestinations() {
		return Arrays.asList(tour);
	}

	public void putCity(int index, City city) {
		tour[index] = city;
	}
	
	public City getCity(int index) {
		return tour[index];
	}
	
	public int numberOfCities() {
		return tour.length;
	}
	
	public double getTourDistance() {
		double distance = 0;
		for (int i = 0; i < tour.length -1; i++) {
			distance += tour[i].distance(tour[i+1]);
		}
		return distance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tour has " + numberOfCities() + " cities: ");
		for (City city : tour) {
			sb.append("(" + city.toString() + ") ");
		}
		sb.append(".");
		return sb.toString();
	}
	
	
}
