package com.onecube.evolve.chromosome;

public interface Chromosome<T> {

    int getSize();

    void setGene(int index, T gene);

    T getGene(int index);

    T[] getGenes();
}

