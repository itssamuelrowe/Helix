package com.onecube.evolve.mutation;

import com.onecube.evolve.population.Individual;

import java.util.function.Function;

@FunctionalInterface
public interface MutationStrategy<T> extends Function<Individual<T>, Individual<T>> {
}
