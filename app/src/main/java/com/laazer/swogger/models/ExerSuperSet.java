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
public class ExerSuperSet implements ExerItem, ExerSet {
    private String name;
    private List<ExerSingleSet> sets;

    public ExerSuperSet() {
        this("");
    }

    public ExerSuperSet(String name) {
        this.name = name;
        this.sets = new ArrayList<>();
    }

    public List<String> getTags() {
        Function<ExerSingleSet, List<String>> toStringList = new Functions.AFunction<ExerSingleSet, List<String>>() {
            @Override
            public List<String> apply(ExerSingleSet exerSet) {
                return exerSet.getTags();
            }
        };
        Function<List<String>, Function<ExerSingleSet, List<String>>> func = Functions.compound(ListUtils.<String>append(), toStringList);
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

    @Override
    public List<String> getItems() {
        return ListUtils.map(this.getSets(), Functions.<ExerSingleSet>toStringObject());
    }

    @Override
    public void addItem(String name) {
        //TODO get this done
    }

    public List<ExerSingleSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerSingleSet> sets) {
        this.sets = sets;
    }

    public void addSet(ExerSingleSet set) {
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
    public ExerSuperSet clone() {
        ExerSuperSet set = new ExerSuperSet(this.name);
        set.setSets(new ArrayList<ExerSingleSet>());
        for (ExerSingleSet s : this.sets) {
            set.addSet(s.clone());
        }
        return set;
    }
}

