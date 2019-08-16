package com.onecube.evolve.selection;

import com.onecube.evolve.Individual;
import com.onecube.evolve.Population;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface SelectionStrategy<T> extends TransformationOperator<Population<T>, Individual<T>> {
}
