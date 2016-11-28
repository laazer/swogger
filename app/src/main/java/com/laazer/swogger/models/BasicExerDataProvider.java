package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class BasicExerDataProvider implements ExerDataProvider {
    private static ExerDataProvider _instance;
    private static List<Workout> workouts;
    private static List<Exercise> exercises;

    private BasicExerDataProvider() {
        workouts = new ArrayList<>();
        exercises = new ArrayList<>();
    }

    public static ExerDataProvider getInstance() {
        if(_instance == null) {
            _instance = new BasicExerDataProvider();
        }
        return _instance;
    }

    @Override
    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public List<Exercise> getExercises() {
        return exercises;
    }
}
