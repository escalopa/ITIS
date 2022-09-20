package db;


import lombok.Data;

@Data
public class Driver {

    public Driver(Integer id, String firstName, String lastName, String phone, Car car, Integer rating, Integer yearOfExperience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.car = car;
        this.rating = rating;
        this.yearOfExperience = yearOfExperience;
    }

    Integer id;
    String firstName;
    String lastName;
    String phone;
    Car car;
    Integer rating;
    Integer yearOfExperience;

}
