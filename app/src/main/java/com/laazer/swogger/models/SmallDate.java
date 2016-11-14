package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class SmallDate {
    private char day; //save memory with char
    private char month;
    private short year;
    public SmallDate(int day, int month, int year) {
        assert day > 0 && day < 32 &&
                month > 0 && month < 13;
        this.day = (char)day;
        this.month = (char)month;
        this.year = (short)year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        assert day > 0 && day < 32;
        this.day = (char)day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        assert month > 0 && month < 13;
        this.month = (char)month;
    }

    public short getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (short)year;
    }
}
