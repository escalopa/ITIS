package task2.components;

import task2.annotations.Component;

import java.util.Date;

@Component
public class Order {

    //Order Users

    int order_id;
    Customer customer;
    Product product;

    int delivery_fees;
    Date arrival_date;
    String arrival_location;

    final String website = " www.ahmad.com";

    public void printOrder() {
        System.out.println(this.website);
    }
}
