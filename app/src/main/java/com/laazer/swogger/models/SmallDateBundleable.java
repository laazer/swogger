package com.laazer.swogger.models;

import android.os.Bundle;

/**
 * Created by Laazer.
 */
public class SmallDateBundleable implements Bundleable<SmallDate> {
    private SmallDate date;

    private static final String TITLE = "SMALL_DATE_";
    private static final String DAY = TITLE + "DAY";
    private static final String MONTH = TITLE + "MONTH";
    private static final String YEAR = TITLE + "YEAR";

    public SmallDateBundleable(Bundle b) {
        getFromBundle(b);
    }

    public SmallDateBundleable(SmallDate date) {
        this.date = date;
    }

    @Override
    public SmallDate getFromBundle(Bundle bundle) {
        int d = bundle.getInt(DAY, -1);
        int m = bundle.getInt(MONTH, -1);
        int y = bundle.getInt(YEAR, -1);
        if(d == -1 || m == -1 || y == -1) return null;
        this.date = new SmallDate(d, m, y);
        return this.date;
    }

    @Override
    public Bundle updateBundle(Bundle bundle) {
        bundle.putInt(DAY, date.getDay());
        bundle.putInt(MONTH, date.getMonth());
        bundle.putInt(YEAR, date.getYear());
        return bundle;
    }

    @Override
    public SmallDate getItem() {
        return this.date;
    }

    @Override
    public void setItem(SmallDate item) {
        this.date = item;
    }
}
