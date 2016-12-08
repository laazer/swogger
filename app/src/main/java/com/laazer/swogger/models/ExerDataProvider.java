package com.laazer.swogger.models;

import java.util.List;

/**
 * Created by Laazer.
 */
public interface ExerDataProvider {

    public List<Workout> getWorkouts();
    public List<Exercise> getExercises();
    public List<ExerSet> getSets();
}
