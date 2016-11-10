package com.laazer.swogger.models;

import java.util.List;

/**
 * Created by Laazer.
 */
public class ExcerSuperSet implements ExcerSet {
    private String name;
    private List<ExcerSet> sets;

    @Override
    public List<String> getTags() {
        return null;
    }
}
