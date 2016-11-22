package com.laazer.swogger.models;

import com.laazer.common.collections.CollectionUtils;
import com.laazer.common.functions.Functions;
import com.laazer.common.functions.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer.
 */
public class BasicExerDataProvider implements ExerDataProvider {
    private ExerDataProvider _instance;
    private List<Day> schedule;

    private BasicExerDataProvider() {
        this.schedule = new ArrayList<>();
    }

    @Override
    public ExerDataProvider getInstance() {
        if (this._instance == null) {
            this._instance = new BasicExerDataProvider();
        }
        return this._instance;
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
}
