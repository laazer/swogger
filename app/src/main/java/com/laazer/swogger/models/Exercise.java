package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer
 */
public class Exercise implements ExerItem {
    private String name;
    private List<ExerSet> sets;
    private int goalReps;

    public Exercise() {
        this("");
    }

    public Exercise(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getItems() {
        return null;
    }

    @Override
    public void addItem(String name) {
        //TODO
    }
}
