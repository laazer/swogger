package com.laazer.swogger.models;

/**
 * Created by Laazer
 */
public class Day {
    private SmallDate date;
    private Workout workout;

    public Day(int day, int month, int year) {
        this.date = new SmallDate(day, month, year);
        this.workout = new Workout();
    }

    public Day() {
        this.date = SmallDate.getToday();
        this.workout = new Workout();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return date != null ? date.equals(day.date) : day.date == null;
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() * 7 : 0;
    }
}

