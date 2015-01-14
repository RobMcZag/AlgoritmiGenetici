package com.rzagni.salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

public class TourSwapMutation implements EvolutionaryOperator<Tour> {

	public TourSwapMutation() {
	}

	@Override
	public List<Tour> apply(List<Tour> selectedCandidates, Random rng) {
		List<Tour> evolved = new ArrayList<Tour>();
		for (Tour candidate : selectedCandidates) {
			Tour tour = new Tour(candidate.getDestinations());
			int p1 = rng.nextInt(tour.numberOfCities());
			int p2 = rng.nextInt(tour.numberOfCities());
			City temp = tour.getCity(p1);
			tour.putCity(p1, tour.getCity(p2));
			tour.putCity(p2, temp);
			evolved.add(tour);
		}
		return evolved;
	}

}
