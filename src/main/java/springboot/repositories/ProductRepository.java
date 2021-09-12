package springboot.repositories;

import org.springframework.stereotype.Repository;
import springboot.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// CRUD
@Repository
public class ProductRepository {
    private List<Product> products;

    public List<Product> findAll(){

        return products;
    }

    public Optional<Product> findByID(int id){

        return products.stream().filter(p->p.getId() == id).findFirst();
    }

    public void add(Product product) {

        this.products.add(product);
    }

    public void remove(int id) {
        Product product = findByID(id).orElseThrow();
        this.products.remove(product);
    }


    @Override
    public String toString(){

        return "ProductRepository{" + "products=" + products + "}";
    }

}


