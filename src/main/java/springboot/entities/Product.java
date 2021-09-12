package springboot.entities;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    public int id;
    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;

    public Product() {
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
          return id;
    }

    public void setId(int id) {
           this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
          this.name = name;
    }

    public float getPrice() {
         return price;
    }

    public void setPrice(float price) {
         this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
