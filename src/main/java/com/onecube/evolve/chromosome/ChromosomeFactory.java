package com.onecube.evolve.chromosome;

public interface ChromosomeFactory<T> {

    Chromosome<T> createChromosome(int size);
    Chromosome<T> createRandomChromosome(int size);
}
