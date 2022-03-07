package app.dbModels;

import app.annotations.*;

import java.sql.Timestamp;

@Entity(name = "order_details")
public class OrderDetails {
    @Id
    int id;
    @OneToMany
    OrderItem order_item;
    @Column
    double total;
    @OneToOne
    PaymentDetails payment_details;
    @Column
    Timestamp created_at;
}
