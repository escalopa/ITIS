package db;

import lombok.Data;

@Data
public class Car {

    public Car(String type, String model) {
        this.type = type;
        this.model = model;
    }

    String type;
    String model;
    
}
