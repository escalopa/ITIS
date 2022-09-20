package app.dbModels;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;

@Entity(name = "payment_details")
public class PaymentDetails {
    @Id
    int id;
    @Column
    double amount;
    @Column
    String provider;
}
