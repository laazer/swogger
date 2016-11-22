package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer
 */
public class Exercise {
    private String name;
    private List<ExerSet> sets;
    private int goalReps;

    public Exercise(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
    }

}
