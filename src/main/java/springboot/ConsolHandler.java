package springboot;

import springboot.entities.CartEntry;
import springboot.entities.Order;
import springboot.entities.Product;
import springboot.entities.User;
import springboot.repositories.ProductRepository;
import springboot.repositories.UserRepository;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Component
public class ConsolHandler {

    private final EntityManager em;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ConsolHandler(EntityManager em, UserRepository userRepository, ProductRepository productRepository) {
        this.em = em;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

}
