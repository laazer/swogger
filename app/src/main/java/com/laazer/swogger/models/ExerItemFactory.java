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
            case 1: return new Workout();
            case 2: return new Exercise();
            case 3: return new ExerSuperSet();
            default: return null;
        }
    }
}
