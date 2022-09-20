package app.dbModels;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;

import java.sql.Timestamp;

@Entity(name = "user")
public class User {
    @Id
    int id;
    @Column
    String username;
    @Column
    String salt;
    @Column
    String password_hash;
    @Column
    String firstname;
    @Column
    String lastname;
    @Column
    String address;
    @Column
    int telephone;
    @Column
    Timestamp created_at;
}
