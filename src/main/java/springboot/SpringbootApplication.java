package springboot;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import springboot.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@SpringBootApplication//активирует бины
@Repository
public class SpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootApplication.class, args);

        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Product newProduct = new Product( "Product_1", 10.00F);
        entityManager.persist(newProduct);
        entityManager.getTransaction().commit();

    }
}
