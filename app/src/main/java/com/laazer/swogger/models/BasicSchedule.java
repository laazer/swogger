package com.laazer.swogger.models;

import com.laazer.common.collections.CollectionUtils;
import com.laazer.common.functions.Functions;
import com.laazer.common.functions.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class BasicSchedule implements Schedule {
    private static Schedule _instance;
    private static List<Day> schedule;

    private BasicSchedule() {
        this.schedule = new ArrayList<>();
    }

    public static Schedule getInstance() {
        if (_instance == null) {
            _instance = new BasicSchedule();
        }
        return _instance;
    }

    @Override
    public Day getToday() {
        Predicate<Day> pred =
                Functions.toPredicate(Functions.<Day, Day>equals().toUnaryFunction(new Day()));
        Day d = CollectionUtils.find(pred , schedule);
        if (d == null) {
            d = new Day();
            this.schedule.add(d);
        }
        return d;
    }

    @Override
    public Day getDate(int day, int month, int year) {
        Day d = CollectionUtils.find(Functions.toPredicate(
                Functions.<Day, Day>equals().toUnaryFunction(new Day(day, month, year))), schedule);
        if (d == null) {
            d = new Day();
            this.schedule.add(d);
        }
        return d;
    }

    @Override
    public Day getDate(SmallDate date) {
        return getDate(date.getDay(), date.getMonth(), date.getYear());
    }
}
