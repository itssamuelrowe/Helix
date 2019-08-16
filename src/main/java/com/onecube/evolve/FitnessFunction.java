package com.onecube.evolve;

import java.util.function.Function;

/**
 * @author Samuel Rowe
 * @since OneCube Evolve 1.0
 */
@FunctionalInterface
public interface FitnessFunction<T> extends Function<Individual<T>, Double> {
}
