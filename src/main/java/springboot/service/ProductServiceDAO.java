package springboot.service;

import springboot.entities.Product;
import springboot.repositories.ProductDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceDAO implements ProductService{
    private final ProductDAORepository productRepository;

    @Autowired
    public ProductServiceDAO(ProductDAORepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {

        return productRepository.findAllSortedByName();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Product product) {

        productRepository.saveOrUpdate(product);
    }

    @Override
    public void deleteById(Long id) {

        productRepository.deleteById(id);
    }
}
