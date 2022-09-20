package db;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class DB {

    public DB(){
        clientList = new LinkedList<>();
        driverList = new LinkedList<>();
        carList = new LinkedList<>();
        tripList = new LinkedList<>();
    }

    List<Client> clientList;
    List<Driver> driverList;
    List<Trip> tripList;
    List<Car> carList;
}
