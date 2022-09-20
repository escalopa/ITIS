package db;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Client {

    public Client(Integer id, String firstName, String lastName, String phone, String birthday, Integer rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthday = birthday;
        this.rating = rating;
    }

    Integer id;
    String firstName;
    String lastName;
    String phone;
    String birthday;
    Integer rating;


}
