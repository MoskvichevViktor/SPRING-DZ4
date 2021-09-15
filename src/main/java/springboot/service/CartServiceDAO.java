package springboot.service;

import springboot.Cart;
import springboot.entities.CartEntry;
import springboot.entities.Product;
import springboot.repositories.ProductDAORepository;
import springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service

public class CartServiceDAO implements CartService{
    private final EntityManager em;

    private final ProductDAORepository productRepository;

    public CartServiceDAO(EntityManager em, ProductDAORepository productRepository) {
        this.em = em;
        this.productRepository = productRepository;
    }

    @Lookup
    @Override
    public Cart getNewCart() {
        return null;
    }

    public List<CartEntry> findAllProductsById(Long orderId) {
        List<CartEntry> cartEntryList = em.createQuery("FROM CartEntry c WHERE c.order_id = :orderId")
                .setParameter("order_id", orderId)
                .getResultList();
        return cartEntryList;
    }


    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        Product product = productRepository.findById(prodId);
        this.addProduct(cart, product, quantity);
    }

    @Override
    public BigDecimal getSum(Cart cart) {
        return cart.getSum();
    }

    public void printCart(Cart cart) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            Product product = entryMap.getKey();
            BigDecimal prodSum = product.getPrice().multiply(BigDecimal.valueOf(entryMap.getValue()));
            sum = sum.add(prodSum);
        }
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        if (cart.getCartMap().containsKey(product)) {
            return cart.getCartMap().get(product);
        }
        return 0;
    }

    @Override
    public Integer getItemsAmount(Cart cart) {
        Integer amount = 0;
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            amount += entryMap.getValue();
        }
        return amount;
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        Product product = productRepository.findById(prodId);
        return this.getProductQuantity(cart, product);
    }

    @Override
    public List<Product> getCartListSorted(Cart cart) {
        List<Product> cartList = new ArrayList<>(cart.getCartMap().keySet());

        return cartList;
    }

}
