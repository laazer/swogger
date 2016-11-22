package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;
import com.laazer.common.collections.CollectionUtils;
import com.laazer.common.collections.ListUtils;
import com.laazer.common.functions.Function;
import com.laazer.common.functions.Functions;

/**
 * Created by Laazer.
 */
public class ExerSuperSet implements ExerSet {
    private String name;
    private List<ExerSet> sets;

    public ExerSuperSet(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
    }

    @Override
    public List<String> getTags() {
        Function<ExerSet, List<String>> toStringList = new Functions.AFunction<ExerSet, List<String>>() {
            @Override
            public List<String> apply(ExerSet exerSet) {
                return exerSet.getTags();
            }
        };
        Function<List<String>, Function<ExerSet, List<String>>> func = Functions.compound(ListUtils.<String>append(), toStringList);
        return CollectionUtils.fold(new ArrayList<String>(),
                Functions.toBinFunction(func),
                this.sets);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExerSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerSet> sets) {
        this.sets = sets;
    }

    public void addSet(ExerSet set) {
        this.sets.add(set);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if(o instanceof ExerSuperSet) return ((ExerSuperSet)o).name.equals(this.name);
        else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 31;
    }

    @Override
    public ExerSet clone() {
        ExerSuperSet set = new ExerSuperSet(this.name);
        set.setSets(new ArrayList<ExerSet>());
        for (ExerSet s : this.sets) {
            set.addSet(s.clone());
        }
        return set;
    }
}

