package com.onecube.evolve.chromosome;

import com.onecube.evolve.*;
import com.onecube.evolve.crossover.CrossoverStrategy;
import com.onecube.evolve.mutation.MutationStrategy;
import com.onecube.evolve.selection.SelectionStrategy;

import java.util.Random;
import java.util.function.UnaryOperator;

public class BinaryChromosome implements Chromosome<Boolean> {

    private Boolean[] genes;

    public BinaryChromosome(int size) {
        this.genes = new Boolean[size];
    }

    @Override
    public void setGene(int index, Boolean gene) {
        genes[index] = gene;
    }

    @Override
    public Boolean getGene(int index) {
        return genes[index];
    }

    @Override
    public int getSize() {
        return genes.length;
    }

    @Override
    public Boolean[] getGenes() {
        return genes;
    }

    // TODO: Throws exception when the genese are not completely filled.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < genes.length; index++) {
            boolean gene = genes[index];
            builder.append(gene? 1 : 0);
            if (index + 1 < genes.length) {
                builder.append(' ');
            }
        }
        return builder.toString();
    }
}

