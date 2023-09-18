package ru.tanz.lab4.transport.driver;

import ru.tanz.lab4.transport.car.Car;
import ru.tanz.lab4.transport.driver.CarDriver;

public class TaxiDriver extends CarDriver {
    String company;
    public TaxiDriver(String name, int age, Car car, String company) {
        super(name, age, car);
        this.company = company;
    }
    public void getInfo() {
        super.getInfo();
        System.out.println("Компания: " + company);
    }
}
