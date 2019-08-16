package com.onecube.evolve.chromosome;

import com.onecube.evolve.chromosome.BinaryChromosome;
import com.onecube.evolve.chromosome.Chromosome;
import com.onecube.evolve.chromosome.ChromosomeFactory;

public class BinaryChromosomeFactory implements ChromosomeFactory<Boolean> {

    @Override
    public Chromosome createChromosome(int size) {
        return new BinaryChromosome(size);
    }

    @Override
    public Chromosome createRandomChromosome(int size) {
        BinaryChromosome chromosome = new BinaryChromosome(size);
        for (int i = 0; i < size; i++) {
            boolean gene = 0.5 < Math.random();
            chromosome.setGene(i, gene);
        }
        return chromosome;
    }
}
