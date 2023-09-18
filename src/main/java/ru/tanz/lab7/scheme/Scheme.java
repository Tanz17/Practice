package ru.tanz.lab7.scheme;

public enum Scheme {
    RUSSIAN(new RussianScheme());
    private final Schematic scheme;
    Scheme(Schematic scheme) {
        this.scheme = scheme;
    }
    public Schematic getScheme()
    {
        return this.scheme;
    }
}
