package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class ExcerSingleSet implements ExcerSet {
    private String name;
    private short repGoal;
    private short repActual;
    private short weight;
    private boolean isFailureSet;
    private List<String> tags;

    public ExcerSingleSet(String name, short repGoal, short repActual,
                          short weight, boolean isFailureSet, List<String> tags) {
        this.name = name;
        this.repGoal = repGoal;
        this.repActual = repActual;
        this.weight = weight;
        this.isFailureSet = isFailureSet;
        this.tags = tags;
    }

    public ExcerSingleSet(String name, short repGoal, short weight) {
        this(name, repGoal, (short)0, weight, false, new ArrayList<String>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getRepGoal() {
        return repGoal;
    }

    public void setRepGoal(short repGoal) {
        this.repGoal = repGoal;
    }

    public short getRepActual() {
        return repActual;
    }

    public void setRepActual(short repActual) {
        this.repActual = repActual;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public boolean isFailureSet() {
        return isFailureSet;
    }

    public void setFailureSet(boolean failureSet) {
        isFailureSet = failureSet;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
