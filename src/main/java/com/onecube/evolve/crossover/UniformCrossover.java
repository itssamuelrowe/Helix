package com.onecube.evolve.crossover;

import com.onecube.evolve.population.Individual;
import com.onecube.evolve.population.SimpleIndividual;
import com.onecube.evolve.chromosome.Chromosome;
import com.onecube.evolve.chromosome.ChromosomeFactory;

public class UniformCrossover<T> implements CrossoverStrategy<T> {

    private ChromosomeFactory<T> chromosomeFactory;

    public UniformCrossover(ChromosomeFactory<T> chromosomeFactory) {
        this.chromosomeFactory = chromosomeFactory;
    }

    @Override
    public Individual<T> apply(Individual<T> individual1, Individual<T> individual2) {
        Chromosome<T> chromosome1 = individual1.getChromosome();
        Chromosome<T> chromosome2 = individual2.getChromosome();
        int chromosomeSize = chromosome1.getSize();

        Chromosome<T> offspringChromosome = chromosomeFactory.createChromosome(chromosomeSize);
        for (int index = 0; index < chromosomeSize; index++) {
            if (0.5 > Math.random()) {
                T gene = chromosome1.getGene(index);
                offspringChromosome.setGene(index, gene);
            }
            else {
                T gene = chromosome2.getGene(index);
                offspringChromosome.setGene(index, gene);
            }
        }

        return new SimpleIndividual<>(offspringChromosome);
    }
}
