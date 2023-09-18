package ru.tanz.lab7.scheme;

import java.util.Map;

public interface  Schematic {
    Map< String, String> getScheme();
    boolean equals(Object obj);
    int hashCode();
}
