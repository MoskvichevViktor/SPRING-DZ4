package springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.entities.Product;
import springboot.repositories.ProductDAORepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductDAOController {

    private final ProductDAORepository repository;

    public ProductDAOController(ProductDAORepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public List<Product> save(@RequestBody Product product) {
        repository.addProductDao(product);
        return repository.listProductDao();
    }


    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findAll(){
        return repository.listProductDao();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List findDAOByID(@PathVariable int id) {

        return repository.findDAOByID(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> delete(@PathVariable int id) {
        repository.removeDeveloper(id);
        return repository.listProductDao();
    }

}