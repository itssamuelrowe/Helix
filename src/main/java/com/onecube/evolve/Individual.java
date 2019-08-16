package com.onecube.evolve;

import com.onecube.evolve.chromosome.Chromosome;

/**
 * @author Samuel Rowe
 * @since OneCube Evolve 1.0
 */
public interface Individual<T> {

    Chromosome<T> getChromosome();

    double getFitness();

    void setFitness(double fitness);
}

