package com.onecube.evolve.population;

import com.onecube.evolve.chromosome.BinaryChromosomeFactory;
import com.onecube.evolve.chromosome.Chromosome;
import com.onecube.evolve.chromosome.ChromosomeFactory;

public class PopulationBuilder<T> {

    private int chromosomeSize;

    private int size;

    private ChromosomeFactory chromosomeFactory;

    private boolean randomIndividuals;

    public PopulationBuilder withChromosomeSize(int chromosomeSize) {
        this.chromosomeSize = chromosomeSize;

        return this;
    }

    public PopulationBuilder withBinaryChromosomes() {
        chromosomeFactory = new BinaryChromosomeFactory();

        return this;
    }

    public PopulationBuilder withRandomIndividuals() {
        randomIndividuals = true;

        return this;
    }

    public PopulationBuilder withSize(int size) {
        this.size = size;

        return this;
    }

    public Population<T> build() {
        Population population = new SimplePopulation(size, 0);

        for (int i = 0; i < size; i++) {
            if (randomIndividuals) {
                Chromosome<T> chromosome = chromosomeFactory.createRandomChromosome(chromosomeSize);
                Individual individual = new SimpleIndividual<T>(chromosome);
                population.addIndividual(individual);
            }
        }

        return population;
    }
}
