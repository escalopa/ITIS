package app.dbModels;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;

@Entity(name = "category")
public class Category {
    @Id
    int id;
    @Column
    String name;
}
