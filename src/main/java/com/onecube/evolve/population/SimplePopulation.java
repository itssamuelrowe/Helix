package com.onecube.evolve.population;

import com.onecube.evolve.FitnessFunction;

import java.util.*;

public class SimplePopulation<T> implements Population<T> {

    private Individual[] individuals;

    private int size;

    private double fitness;

    private int generation;

    public SimplePopulation(int limit, int generation) {
        this.individuals = new Individual[limit];
        this.size = 0;
        this.fitness = Double.NaN;
        this.generation = generation;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getLimit() {
        return individuals.length;
    }

    @Override
    public Population getNextGeneration() {
        return null;
    }

    @Override
    public void addIndividual(Individual individual) {
        individuals[size++] = individual;
    }

    @Override
    public Individual getIndividual() {
        return getIndividual(0);
    }

    @Override
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    @Override
    public Individual[] getIndividuals() {
        return individuals;
    }

    @Override
    public double getFitness() {
        if (Double.isNaN(fitness)) {
            throw new IllegalStateException("The fitness of the population is unevaluated.");
        }
        return fitness;
    }

    @Override
    public double evaluate(FitnessFunction<T> function) {
        fitness = 0.0;
        for (Individual individual : individuals) {
            double individualFitness = function.apply(individual);
            individual.setFitness(individualFitness);
            fitness += individualFitness;
        }
        return fitness;
    }

    @Override
    public void sort() {
        Arrays.sort(individuals, Collections.reverseOrder((individual1, individual2) -> {
            double fitness1 = individual1.getFitness();
            double fitness2 = individual2.getFitness();
            return Double.compare(fitness1, fitness2);
        }));
    }

    @Override
    public int getGeneration() {
        return generation;
    }
}
