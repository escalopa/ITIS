package task2.components;

import lombok.Data;
import task2.annotations.Autowire;
import task2.annotations.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Component
public class Customer {

    int customer_id;
    String name;
    String address;

    @Autowire
    private List<Order> orders;

    double balance;

    public void printOrders() {
        System.out.println(orders);
    }
}
