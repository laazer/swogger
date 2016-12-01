package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class ScheduleFactory {

    public static final Schedule getDefaultSchedule() {
        return getBasicSchedule();
    }

    public static final Schedule getBasicSchedule() {
        return BasicSchedule.getInstance();
    }

    public static final Schedule getDBSchedule() {
        //TODO make a schedule that works with a db
        return null;
    }
}
