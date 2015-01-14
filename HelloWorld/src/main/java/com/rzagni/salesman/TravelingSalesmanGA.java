package com.rzagni.salesman;

import java.util.ArrayList;
import java.util.List;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.watchmaker.framework.CandidateFactory;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.PopulationData;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.Stagnation;

public class TravelingSalesmanGA {

	/* number of cities to find the best tour */
	public static int NUM_CITIES = 50;
	
	protected static List<City> destinations ;
	
	public static void main(String[] args) {
		destinations = generateRandomCities(NUM_CITIES);
		
		CandidateFactory<Tour> candidateFactory = new TourFactory(destinations);

    	// List of Evolutionary operators to use in the operators pipeline
        List<EvolutionaryOperator<Tour>> operators = new ArrayList<EvolutionaryOperator<Tour>>(2);
        	operators.add(new TourSwapMutation());
        	//operators.add(new TourCrossover());
        EvolutionaryOperator<Tour> evolutionOperatorsPipeline = new EvolutionPipeline<Tour>(operators);
        
        EvolutionEngine<Tour> engine = new GenerationalEvolutionEngine<Tour>(candidateFactory,
                                                                                 evolutionOperatorsPipeline,
                                                                                 new TourEvaluator(),
                                                                                 new RouletteWheelSelection(),
                                                                                 new MersenneTwisterRNG());
        
        engine.addEvolutionObserver(new EvolutionLogger());
        
         engine.evolve(100, // 100 individuals in the population.
                       5, // 5% elitism.
                       new Stagnation(100, false, false));

		
	}

	/**
	 * Generate the desired number of cities 
	 */
	protected static List<City> generateRandomCities(int numCities) {
		ArrayList<City> dests = new ArrayList<City>();
		for (int i = 0; i < numCities; i++) {
			dests.add(new City());
		}
		return dests;
	}

    /**
     * Trivial evolution observer for displaying information at the end
     * of each generation.
     */
    private static class EvolutionLogger implements EvolutionObserver<Tour>
    {
    	private double startFitness = 0;
    	
        public void populationUpdate(PopulationData<? extends Tour> data)
        {
        	if(data.getGenerationNumber() == 0) {
        		startFitness = data.getBestCandidateFitness();
        	}
            System.out.printf("Generation %d: [%s VS %s] %s %n",
                              data.getGenerationNumber(),
                              data.getBestCandidateFitness(),
                              startFitness,
                              data.getBestCandidate()
                              );
        }
    }

}
