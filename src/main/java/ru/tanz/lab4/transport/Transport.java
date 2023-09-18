package ru.tanz.lab4.transport;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transport {
    String brand;
    int year;
    String model;

    public void getInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Год производства: " + year);
    }
}
