package springboot.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_products")
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "quantity")
    private Long quantity;

    @Column (name = "acquire_price")
    private BigDecimal acquirePrice;


    @Override
    public String toString() {
        return "CartEntry{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", acquirePrice=" + acquirePrice +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getAcquirePrice() {
        return acquirePrice;
    }
}