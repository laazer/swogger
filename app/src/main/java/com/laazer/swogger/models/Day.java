package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer
 */
public class Day {
    private SmallDate date;
    private List<Exercise> exercises;

    public Day(int day, int month, int year) {
        this.date = new SmallDate(day, month, year);
        this.exercises = new ArrayList<Exercise>();
    }

    public Day() {
        this.date = SmallDate.getToday();
        this.exercises = new ArrayList<>();
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

