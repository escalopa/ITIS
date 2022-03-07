package app.dbModels;

import app.annotations.*;

@Entity(name = "product")
public class Product {
    @Id
    int id;
    @Column
    String name;
    @Column
    String sku;
    @ManyToOne
    Category category;
    @Column
    double price;
    @Column
    int discount_percentage;
}
