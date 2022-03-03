package db;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trip {


    Integer id;
    Client client;
    Driver driver;
    String meetingPoint;
    String destination;
    Integer price;

}
