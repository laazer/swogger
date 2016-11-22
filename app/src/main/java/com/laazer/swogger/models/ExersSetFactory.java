package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class ExersSetFactory {

    public final static ExerSet getNonMaxExerset(String name, int weight, int repGoal) {
        return new ExerSingleSet(name, (short)repGoal, (short)weight);
    }

    public final static ExerSet getMaxingExerset(String name, int weight) {
        return new ExerSingleSet(name, (short)weight);
    }

    public final static ExerSet getSuperSet(String name) {
        return new ExerSuperSet(name);
    }
}
