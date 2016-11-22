package com.laazer.swogger.models;

import com.laazer.common.collections.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class Workout {
    private String name;
    private List<Exercise> exercises;

    public Workout() {
        exercises = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public List<String> getTags() {
        return null;
    }
}
