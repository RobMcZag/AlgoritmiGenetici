package com.rzagni.salesman;

import java.util.List;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

public class TourEvaluator implements FitnessEvaluator<Tour> {

	public TourEvaluator() {
	}

	/**
	 * Calculate Tour's fitness as the total distance of the tour
	 */
	@Override
	public double getFitness(Tour candidate, List<? extends Tour> population) {
		return candidate.getTourDistance();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean isNatural() {
		return false;	// Shortest distance is better fitness
	}

}
