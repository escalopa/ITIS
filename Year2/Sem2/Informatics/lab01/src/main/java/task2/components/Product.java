package task2.components;

import task2.annotations.Autowire;
import task2.annotations.Component;

import java.awt.*;

@Component
public class Product {

    int product_id;
    int quantity;
    double price;

    Image image;

    @Autowire
    Customer seller;
}
