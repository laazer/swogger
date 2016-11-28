package com.laazer.swogger.models;

import android.os.Bundle;

/**
 * Created by Laazer.
 */
public interface Bundleable<T> {

    public T getFromBundle(Bundle bundle);
    public Bundle updateBundle(Bundle bundle);
    public T getItem();
    public void setItem(T item);
}
