package com.onecube.evolve.selection;

import com.onecube.evolve.population.Individual;
import com.onecube.evolve.population.Population;

@FunctionalInterface
public interface SelectionStrategy<T> extends TransformationOperator<Population<T>, Individual<T>> {
}
