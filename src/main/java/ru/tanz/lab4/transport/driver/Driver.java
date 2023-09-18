package ru.tanz.lab4.transport.driver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver{
    String name;
    int age;

    public Driver(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("имя: " + name);
        System.out.println("Возраст: " + age);
    }
}
