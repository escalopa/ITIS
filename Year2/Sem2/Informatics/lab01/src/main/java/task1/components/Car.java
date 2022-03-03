package task1.components;

import task1.annotations.Alive;
import task1.annotations.SuperAcceleration;

public class Car {

    int seat;

    @Alive
    Driver driver;

    Wheel[] wheels;

    @SuperAcceleration
    int speed = 0;

    public void park() {
        System.out.println("parking");
    }
}
