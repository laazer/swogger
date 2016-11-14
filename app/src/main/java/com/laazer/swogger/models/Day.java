package com.laazer.swogger.models;

import java.util.List;

/**
 * Created by Dexter on 11/9/2016.
 */
public class Day {
    private SmallDate date;
    private List<Exercise> workout;


    public void Exercise(Exercise exercise) {
        workout.add(exercise);
    }
}

