package com.laazer.swogger.models;

import java.util.Calendar;
import java.util.Date;

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

    public final static SmallDate getToday() {
        Calendar c = Calendar.getInstance();
        return new SmallDate(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH),
                c.get(Calendar.YEAR));
    }

    public boolean isToday() {
        return this.equals(getToday());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallDate smallDate = (SmallDate) o;
        if (day != smallDate.day) return false;
        if (month != smallDate.month) return false;
        return year == smallDate.year;
    }

    @Override
    public int hashCode() {
        int result = (int) day;
        result = 31 * result + (int) month;
        result = 31 * result + (int) year;
        return result;
    }
}
