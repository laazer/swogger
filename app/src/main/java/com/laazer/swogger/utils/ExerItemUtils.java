package com.laazer.swogger.utils;

import com.laazer.common.functions.Function;
import com.laazer.common.functions.Functions;
import com.laazer.swogger.models.ExerItem;

/**
 * Created by Laazer.
 */
public class ExerItemUtils {

    public static final Function<ExerItem, String> toString = new Functions.AFunction<ExerItem, String>() {
        @Override
        public String apply(ExerItem exerItem) {
            return exerItem.getName();
        }
    };
}
