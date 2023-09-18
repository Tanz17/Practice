package ru.tanz.lab4.transport.driver;

import ru.tanz.lab4.transport.car.Car;
import ru.tanz.lab4.transport.driver.CarDriver;

public class ServiceCarDriver extends CarDriver {
    int serviceCost;
    public ServiceCarDriver(String name, int age, Car car, int serviceCost) {
        super(name, age, car);
        this.serviceCost = serviceCost;
    }
    public void getInfo(){
        super.getInfo();
        System.out.println("Стоимость услуг: " + serviceCost);
    }
}
