package com.onecube.evolve.population;

import com.onecube.evolve.chromosome.Chromosome;

public class SimpleIndividual<T> implements Individual<T> {

    private Chromosome<T> chromosome;

    private double fitness;

    public SimpleIndividual(Chromosome<T> chromosome) {
        this(chromosome, Double.NaN);
    }

    public SimpleIndividual(Chromosome chromosome, double fitness) {
        this.chromosome = chromosome;
        this.fitness = fitness;
    }

    public void setChromosome(Chromosome<T> chromosome) {
        this.chromosome = chromosome;
    }

    @Override
    public Chromosome<T> getChromosome() {
        return chromosome;
    }

    @Override
    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public double getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return fitness + ", " + chromosome.toString();
    }
}
