package com.onecube.evolve.crossover;

import com.onecube.evolve.Individual;

import java.util.function.BinaryOperator;

public interface CrossoverStrategy<T> extends BinaryOperator<Individual<T>> {
}
