package app.dbModels;

import app.annotations.*;

@Entity(name = "order")
public class Order {
    @Id
    int id;
    @ManyToOne
    User user;
    @OneToOne
    OrderDetails order_details;
}
