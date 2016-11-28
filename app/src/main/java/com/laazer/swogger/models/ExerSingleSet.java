package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class ExerSingleSet implements ExerSet {
    private String name;
    private short repGoal;
    private short repActual;
    private short weight;
    private boolean isFailureSet;
    private List<String> tags;
    private String comments;

    public ExerSingleSet(String name, short repGoal, short repActual,
                         short weight, boolean isFailureSet, List<String> tags) {
        this.name = name;
        this.repGoal = repGoal;
        this.repActual = repActual;
        this.weight = weight;
        this.isFailureSet = isFailureSet;
        this.tags = tags;
    }

    public ExerSingleSet(String name, short repGoal, short weight) {
        this(name, repGoal, (short)0, weight, false, new ArrayList<String>());
    }

    public ExerSingleSet(String name, short weight) {
        this(name, (short)-1, (short)0, weight, true, new ArrayList<String>());
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o instanceof ExerSingleSet) return ((ExerSingleSet)o).name.equals(this.name);
        else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 7;
    }

    @Override
    public ExerSet clone() {
        ExerSingleSet set = new ExerSingleSet(this.name, this.repGoal, this.weight);
        set.setFailureSet(this.isFailureSet);
        set.tags = new ArrayList<>();
        for(String tag : set.tags) {
            set.tags.add(tag);
        }
        return set;
    }


}
