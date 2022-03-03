package db;

import lombok.Data;

@Data
public class Trip {

    public Trip(Integer id, Client client, Driver driver, String meetingPoint, String destination, Integer price) {
        this.id = id;
        this.client = client;
        this.driver = driver;
        this.meetingPoint = meetingPoint;
        this.destination = destination;
        this.price = price;
    }

    Integer id;
    Client client;
    Driver driver;
    String meetingPoint;
    String destination;
    Integer price;

}
