package springboot.repositories;

import org.hibernate.Transaction;
import springboot.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAORepository {

    private static SessionFactory sessionFactory;

    public void addProductDao(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        //Product product = new Product();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public List<Product> listProductDao() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List products = session.createQuery("FROM Product ").list();

        transaction.commit();
        session.close();
        return products;
    }

    public List findDAOByID(int ID) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List products = session.createQuery("FROM Product where id =:ID").list();

        transaction.commit();
        session.close();
        return products;
    }

    public void removeDeveloper(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.close();
    }

}
