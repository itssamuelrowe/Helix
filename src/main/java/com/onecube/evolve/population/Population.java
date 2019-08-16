package com.onecube.evolve.population;

import com.onecube.evolve.FitnessFunction;

/**
 * @author Samuel Rowe
 * @since OneCube Evolve 1.0
 */
public interface Population<T> {

    int getSize();

    int getLimit();

    Population<T> getNextGeneration();

    void addIndividual(Individual<T> individual);

    Individual<T> getIndividual();

    Individual<T> getIndividual(int index);

    Individual<T>[] getIndividuals();

    double getFitness();

    double evaluate(FitnessFunction<T> function);

    void sort();

    int getGeneration();
}

