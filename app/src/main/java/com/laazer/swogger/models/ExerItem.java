package com.laazer.swogger.models;

import java.util.List;

/**
 * Created by Laazer.
 */
public interface ExerItem {
    String getName();
    void setName(String name);
    List<String> getItems();
    void addItem(String name);
}
