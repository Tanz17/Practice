package ru.tanz.lab4.transport.driver;

import ru.tanz.lab4.transport.car.Car;

public class CarDriver extends Driver{
    Car car;
    public CarDriver(String name, int age, Car car) {
        super(name, age);
        this.car = car;
    }
    public void getInfo() {
        super.getInfo();
        car.getInfo();
    }
}
