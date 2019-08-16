package com.onecube.evolve.chromosome;

public class IntegerChromosome implements Chromosome<Integer> {

    private Integer[] genes;

    public IntegerChromosome(int size) {
        this.genes = new Integer[size];
    }

    public IntegerChromosome(Integer[] genes) {
        this.genes = genes;
    }

    public void setGene(int index, Integer gene) {
        genes[index] = gene;
    }

    @Override
    public Integer getGene(int index) {
        return genes[index];
    }

    @Override
    public int getSize() {
        return genes.length;
    }

    @Override
    public Integer[] getGenes() {
        return genes;
    }
}
