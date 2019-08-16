package com.onecube.evolve.mutation;

import com.onecube.evolve.population.Individual;
import com.onecube.evolve.population.SimpleIndividual;
import com.onecube.evolve.chromosome.Chromosome;
import com.onecube.evolve.chromosome.ChromosomeFactory;

public class BinaryFlipMutation implements MutationStrategy<Boolean> {

    private ChromosomeFactory<Boolean>chromosomeFactory;
    
    private double mutationRate;

    public BinaryFlipMutation(ChromosomeFactory<Boolean> chromosomeFactory, double mutationRate) {
        this.chromosomeFactory = chromosomeFactory;
        this.mutationRate = mutationRate;
    }

    @Override
    public Individual<Boolean> apply(Individual<Boolean> individual) {
        Chromosome<Boolean> chromosome = individual.getChromosome();
        int chromosomeSize = chromosome.getSize();

        Chromosome<Boolean> offspringChromosome = chromosomeFactory.createChromosome(chromosomeSize);
        for (int index = 0; index < chromosomeSize; index++) {
            boolean gene = chromosome.getGene(index);
            if (Math.random() < mutationRate) {
                 gene = !gene;
            }
            offspringChromosome.setGene(index, !gene);
        }

        return new SimpleIndividual(offspringChromosome);
    }
}
