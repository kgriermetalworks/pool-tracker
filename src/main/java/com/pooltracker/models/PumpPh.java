package com.pooltracker.models;

public enum PumpPh {

    ONEPH("1"),
    TWOPH("2"),
    THREEPH("3");

    private final String name;

    PumpPh(String name) { this.name = name; }

    public String getName() { return name; }

}
