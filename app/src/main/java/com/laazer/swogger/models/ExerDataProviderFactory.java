package com.laazer.swogger.models;

/**
 * Created by Laazer.
 */
public class ExerDataProviderFactory {

    public static final ExerDataProvider getDefaultProiver() {
        return getBasicProvider();
    }

    public static final ExerDataProvider getBasicProvider() {
        return BasicExerDataProvider.getInstance();
    }

    public static final ExerDataProvider getDBProvider() {
        //TODO
        return null;
    }

}
