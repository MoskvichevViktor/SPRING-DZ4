package springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.entities.Product;
import springboot.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findAll(){
        return repository.findAll();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Product> findByID(@PathVariable int id) {
        return repository.findByID(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public List<Product> save(@RequestBody Product product) {
        repository.add(product);
        return repository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> delete(@PathVariable int id) {
        repository.remove(id);
        return repository.findAll();
    }

}










