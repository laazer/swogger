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
        return day == smallDate.day && month == smallDate.month &&
            year == smallDate.year;
    }

    @Override
    public int hashCode() {
        int result = (int) day;
        result = 31 * result + (int) month;
        result = 31 * result + (int) year;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getShortMonthString());
        sb.append(" ");
        sb.append(this.getDay());
        sb.append(", ");
        sb.append(this.getYear());
        return sb.toString();
    }

    public String getMonthString() {
        switch (this.getMonth()) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid Month";
        }
    }

    public String getShortMonthString() {
        String month = this.getMonthString();
        if (month.length() <= 4) {
            return month;
        }
        else {
            return month.substring(0, 3) + ".";
        }
    }
}
