package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class ExerItemFactory {

    public static final int WORKOUT = 1;
    public static final int EXERCISE = 2;
    public static final int SET = 3;

    public static final ExerItem getExerItem(int arg) {
        switch (arg) {
            case WORKOUT: return new Workout();
            case EXERCISE: return new Exercise();
            case SET: return new ExerSuperSet();
            default: return null;
        }
    }
}
