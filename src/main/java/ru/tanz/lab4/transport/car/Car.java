package ru.tanz.lab4.transport.car;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.tanz.lab4.transport.Transport;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car extends Transport {

    int maxSpeed;

    public Car(String brand, String model, int year, int maxSpeed) {
        super(brand, year, model);
        this.maxSpeed = maxSpeed;
    }
    public void getInfo() {
        super.getInfo();
        System.out.println("Максимальная скорость: " + maxSpeed);
    }
}
