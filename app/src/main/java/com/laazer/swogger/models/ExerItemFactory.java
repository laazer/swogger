package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class ExerItemFactory {

    public static final ExerItem getExerItem(int arg) {
        switch (arg) {
            case 1: return new Workout();
            case 2: return new Exercise();
            case 3: return new ExerSuperSet();
            default: return null;
        }
    }
}
