package com.onecube.evolve;

import com.onecube.evolve.*;
import com.onecube.evolve.crossover.CrossoverStrategy;
import com.onecube.evolve.mutation.MutationStrategy;
import com.onecube.evolve.selection.SelectionStrategy;

import java.util.Random;

public class GeneticAlgorithm<T> {

    private static final Random random = new Random();

    private SelectionStrategy<T> selectionStrategy;

    private CrossoverStrategy<T> crossoverStrategy;

    private double crossoverRate;

    private MutationStrategy<T> mutationStrategy;

    private double mutationRate;

    private FitnessFunction<T> fitnessFunction;

    private TerminationCondition terminationCondition;

    private int generation;

    private int maximumGenerations;

    private int elitismCount;

    public GeneticAlgorithm(SelectionStrategy<T> selectionStrategy,
        CrossoverStrategy<T> crossoverStrategy, double crossoverRate,
        MutationStrategy<T> mutationStrategy, double mutationRate,
        FitnessFunction<T> fitnessFunction, TerminationCondition terminationCondition,
        int maximumGenerations, int elitismCount) {
        this.selectionStrategy = selectionStrategy;
        this.crossoverStrategy = crossoverStrategy;
        this.crossoverRate = crossoverRate;
        this.mutationStrategy = mutationStrategy;
        this.mutationRate = mutationRate;
        this.fitnessFunction = fitnessFunction;
        this.terminationCondition = terminationCondition;
        this.generation = 0;
        this.maximumGenerations = maximumGenerations;
        this.elitismCount = elitismCount;
    }

    public CrossoverStrategy getCrossoverStrategy() {
        return crossoverStrategy;
    }

    public void setCrossoverStrategy(CrossoverStrategy<T> crossoverStrategy) {
        this.crossoverStrategy = crossoverStrategy;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public MutationStrategy getMutationStrategy() {
        return mutationStrategy;
    }

    public void setMutationStrategy(MutationStrategy<T> mutationStrategy) {
        this.mutationStrategy = mutationStrategy;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public TerminationCondition getTerminationCondition() {
        return terminationCondition;
    }

    public void setTerminationCondition(TerminationCondition terminationCondition) {
        this.terminationCondition = terminationCondition;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getMaximumGenerations() {
        return maximumGenerations;
    }

    public void setMaximumGenerations(int maximumGenerations) {
        this.maximumGenerations = maximumGenerations;
    }

    public int getElitismCount() {
        return elitismCount;
    }

    public void setElitismCount(int elitismCount) {
        this.elitismCount = elitismCount;
    }

    public FitnessFunction getFitnessFunction() {
        return fitnessFunction;
    }

    public void setFitnessFunction(FitnessFunction fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
    }

    private void prepare(Population<T> population) {
        population.evaluate(fitnessFunction);
        population.sort();
    }

    private Population<T> crossover(Population<T> population) {
        int size = population.getSize();
        Population<T> newPopulation = new SimplePopulation<>(size, -1);

        for (int index = 0; index < size; index++) {
            Individual<T> parent1 = population.getIndividual(index);
            if ((index > elitismCount) && (Math.random() < crossoverRate)) {
                Individual<T> parent2 = selectionStrategy.apply(population);
                Individual<T> offspring = crossoverStrategy.apply(parent1, parent2);
                newPopulation.addIndividual(offspring);
            }
            else {
                newPopulation.addIndividual(parent1);
            }
        }

        return newPopulation;
    }

    private Population<T> mutate(Population<T> population) {
        int size = population.getSize();
        Population<T> newPopulation = new SimplePopulation<>(size, generation);

        for (int index = 0; index < size; index++) {
            Individual<T> individual = population.getIndividual(index);
            if ((index > elitismCount) && (Math.random() < mutationRate)) {
                individual = mutationStrategy.apply(individual);
            }
            newPopulation.addIndividual(individual);
        }

        return newPopulation;
    }

    public Population evolve(Population<T> population) {
        prepare(population);
        do {
            population = crossover(population);

            prepare(population);
            population = mutate(population);

            prepare(population);
            System.out.printf("Generation: %d, Best Solution: %s\n", generation, population.getIndividual(0));

            generation++;
        }
        while (!terminationCondition.test(population) && (generation < maximumGenerations));

        return population;
    }
}
