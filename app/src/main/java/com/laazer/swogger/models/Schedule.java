package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public interface Schedule {

    public Day getToday();
    public Day getDate(int day, int month, int year);
    public Day getDate(SmallDate date);
}
