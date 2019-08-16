package com.onecube.evolve.selection;

@FunctionalInterface
public interface TransformationOperator<T, R> {

    R apply(T operand);
}
