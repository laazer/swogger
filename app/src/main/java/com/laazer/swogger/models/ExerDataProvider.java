package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public interface ExerDataProvider {

    public ExerDataProvider getInstance();
    public Day getToday();
    public Day getDate(int day, int month, int year);
}
