package com.laazer.swogger.models;

import com.laazer.common.collections.ListUtils;
import com.laazer.common.functions.Functions;
import com.laazer.swogger.utils.ExerItemUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laazer
 */
public class Exercise implements ExerItem {
    private String name;
    private List<ExerSet> sets;
    private int goalReps;

    public Exercise() {
        this.name = "";
        this.sets = new ArrayList<>();
    }

    public Exercise(String name) {
        this();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getItems() {
        return ListUtils.map(this.sets, new Functions.AFunction<ExerSet, String>() {
            @Override
            public String apply(ExerSet s) {
                return s.getName();
            }
        });
    }

    @Override
    public void addItem(String name) {
        //TODO
    }
}
