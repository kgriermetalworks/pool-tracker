package com.pooltracker.models;

public enum PumpHp {

    HPTHREEQTR("3/4"),
    HPONE("1.0"),
    HPONEHALF("1.5"),
    HPTWO("2.0"),
    HPTWOHALF("2.5"),
    HPTHREE("3.0"),
    HPFOUR("4.0"),
    HPFOURHALF("4.5"),
    HPFIVE("5.0"),
    HPFIVEHALF("5.5");

    private final String name;

    PumpHp(String name) { this.name = name; }

    public String getName() { return name; }

}
