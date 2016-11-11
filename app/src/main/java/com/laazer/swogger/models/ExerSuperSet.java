package com.laazer.swogger.models;

import java.util.ArrayList;
import java.util.List;
import com.laazer.common.collections.CollectionUtils;
import com.laazer.common.functions.Function;
import com.laazer.common.functions.Functions;

/**
 * Created by Laazer.
 */
public class ExerSuperSet implements ExerSet {
    private String name;
    private List<ExerSet> sets;

    public ExerSuperSet(String name, List<ExerSet> sets) {
        this.name = name;
        this.sets = sets;
    }

    @Override
    public List<String> getTags() {
        return CollectionUtils.fold(new ArrayList<String>(), Functions.toBinFunction(new AppendTags()),
                this.sets);
    }

    static class AppendTags implements Function<List<String>, Function<ExerSet, List<String>>> {

        public Function<ExerSet, List<String>> apply(List<String> value) {
            return new Append1(value);
        }

        private class Append1 implements Function<ExerSet, List<String>> {
            List<String> x;
            Append1(List<String> x) {
                this.x = x;
            }

            public List<String> apply(ExerSet value) {
                List<String> result = new ArrayList<>();
                result.addAll(x); result.addAll(value.getTags());
                return result;
            }
        }
    }

}

