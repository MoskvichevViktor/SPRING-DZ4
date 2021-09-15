package springboot;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;

@Configuration
public class PersistenceConfig{

    @Bean
    public EntityManager entityManager(SessionFactory sessionFactory) {

        return sessionFactory.createEntityManager();
    }
}
