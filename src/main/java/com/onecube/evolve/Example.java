package com.onecube.evolve;

import com.onecube.evolve.chromosome.BinaryChromosome;
import com.onecube.evolve.chromosome.BinaryChromosomeFactory;
import com.onecube.evolve.chromosome.ChromosomeFactory;
import com.onecube.evolve.crossover.UniformCrossover;
import com.onecube.evolve.mutation.BinaryFlipMutation;
import com.onecube.evolve.population.PopulationBuilder;
import com.onecube.evolve.selection.RouletteWheelSelection;

/**
 * @author Samuel Rowe
 * @since OneCube Evolve 1.0
 */
class SimpleFitnessFunction implements FitnessFunction<Boolean> {

    public Double apply(Individual<Boolean> individual) {
        int correctGenes = 0;

        BinaryChromosome chromosome = (BinaryChromosome)individual.getChromosome();
        int chromosomeSize = chromosome.getSize();
        for (int index = 0; index < chromosomeSize; index++) {
            if (chromosome.getGene(index)) {
                correctGenes += 1;
            }
        }

        return (double)correctGenes / chromosomeSize;
    }
}

/**
 * @author Samuel Rowe
 * @since OneCube Evolve 1.0
 */
public class Example {

    public static void main(String... arguments) {
        Population population = new PopulationBuilder()
            .withSize(100)
            .withRandomIndividuals()
            .withBinaryChromosomes()
            .withChromosomeSize(50)
            .build();

        ChromosomeFactory<Boolean> chromosomeFactory = new BinaryChromosomeFactory();

        GeneticAlgorithm<? extends java.io.Serializable> algorithm = new GeneticAlgorithm<>(
                new RouletteWheelSelection<>(),
                new UniformCrossover<>(chromosomeFactory), 0.95,
                new BinaryFlipMutation(chromosomeFactory, 0.01), 1,
                new SimpleFitnessFunction(),
                currentPopulation -> currentPopulation.getIndividual(0).getFitness() == 1.0,
                Integer.MAX_VALUE, 3);
        Population evolvedPopulation = algorithm.evolve(population);

        Individual solution = evolvedPopulation.getIndividual(0);
        System.out.printf("Found the solution with %f fitness after %d generations.\n%s\n",
            solution.getFitness(), evolvedPopulation.getGeneration(), solution.getChromosome());
    }
}
