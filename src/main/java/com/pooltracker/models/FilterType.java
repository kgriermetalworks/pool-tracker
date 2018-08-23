package com.pooltracker.models;

/**
 * Created by Kevin Grier
 */

public enum FilterType {

    SAND("Sand"),
    DE("D.E."),
    CART("Cartridge");



    private final String name;

    FilterType(String name) { this.name = name; }

    public String getName() { return name; }


}
