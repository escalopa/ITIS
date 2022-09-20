package web.app.lab04.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "orders")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = true)
    private BigInteger user_id;
    @Basic
    @Column(name = "product_id", nullable = true)
    private BigInteger product_id;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "total", nullable = true)
    private BigInteger total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!Objects.equals(user_id, order.user_id)) return false;
        if (!Objects.equals(product_id, order.product_id)) return false;
        if (!Objects.equals(quantity, order.quantity)) return false;
        return Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (product_id != null ? product_id.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
