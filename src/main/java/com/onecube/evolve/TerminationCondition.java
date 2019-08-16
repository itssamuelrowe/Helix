package com.onecube.evolve;

import com.onecube.evolve.population.Population;

import java.util.function.Predicate;

public interface TerminationCondition extends Predicate<Population> {

}
