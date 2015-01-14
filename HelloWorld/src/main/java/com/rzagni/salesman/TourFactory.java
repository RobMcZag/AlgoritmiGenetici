package com.rzagni.salesman;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

/*
 * Creates new populations of candidates. 
 * For most implementations it will be easiest just to extend
 * org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory
 * and implement the method to generate a single random candidate.
 * 
 */
public class TourFactory extends AbstractCandidateFactory<Tour> {

	private final List<City> destinations ;
	
	/**
	 * Creates a Factory that can generate random tours with the Cities passed as destinations
	 * @param destinations The list holding 
	 */
	public TourFactory(List<City> destinations) {
		this.destinations = destinations;
	}

	@Override
	public Tour generateRandomCandidate(Random rng) {
		Collections.shuffle(destinations, rng);
		return new Tour(destinations);
	}

}
