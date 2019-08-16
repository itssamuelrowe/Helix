package com.onecube.evolve.selection;

import com.onecube.evolve.Individual;
import com.onecube.evolve.Population;

public class RouletteWheelSelection<T> implements SelectionStrategy<T> {

    @Override
    public Individual<T> apply(Population<T> population) {
        Individual[] individuals = population.getIndividuals();

        double fitness = population.getFitness();
        double rouletteWheelPosition = Math.random() * fitness;

        int size = population.getSize();
        Individual result = population.getIndividual(size - 1);

        double spinWheel = 0;
        for (Individual individual : individuals) {
            spinWheel += individual.getFitness();
            if (spinWheel >= rouletteWheelPosition) {
                result = individual;
                break;
            }
        }
        return result;
    }
}
