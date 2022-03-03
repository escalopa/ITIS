package db;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Driver {

    Integer id;
    String firstName;
    String lastName;
    String phone;
    Car car;
    Integer rating;
    Integer yearOfExperience;

}
