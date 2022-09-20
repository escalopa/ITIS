package app.dbModels;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;
import app.annotations.ManyToOne;

import java.sql.Timestamp;

@Entity(name = "order_item")
public class OrderItem {
    @Id
    int id;
    @ManyToOne
    Product product;
    @Column
    int quantity;
    @Column
    Timestamp created_at;
}
