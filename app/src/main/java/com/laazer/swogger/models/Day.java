package com.laazer.swogger.models;


import org.joda.time.DateTime;

/**
 * Created by Laazer
 */
public class Day {
    private DateTime date;
    private Workout workout;

    public Day(int day, int month, int year) {
        this.date = new DateTime(year, month, day, 0, 0, 0);
        this.workout = new Workout();
    }

    public Day() {
        this.date = new DateTime();
        this.workout = new Workout();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return date.getDayOfYear() == day.getDate().getDayOfYear() &&
                date.getYear() == day.date.getYear();
    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() * 13 : 0;
    }

    @Override
    public String toString() {
        return date.monthOfYear().getAsShortText() + " " + date.getDayOfMonth() + ", " +
                date.getYear();
    }

    public DateTime getDate() {
        return date;
    }

    public SmallDate getSmallDate() {
        return new SmallDate(date.getDayOfMonth(), date.getMonthOfYear(), date.getYear());
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}

