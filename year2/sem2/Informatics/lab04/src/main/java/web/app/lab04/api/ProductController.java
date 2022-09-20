package web.app.lab04.api;

import org.springframework.web.bind.annotation.*;
import web.app.lab04.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path = {"/", ""}, produces = "application/json")
    public List<Product> getProducts() {
        return entityManager.createQuery("SELECT p FROM products p", Product.class).getResultList();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Product getProduct(@PathVariable long id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product product) {
        entityManager.persist(product);
        return product;
    }

    @Transactional
    @PutMapping(path = "/{id}/edit", consumes = "application/json", produces = "application/json")
    public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
        Product originalProduct = entityManager.find(Product.class, id);
        originalProduct.setName(product.getName());
        originalProduct.setPrice(product.getPrice());
        originalProduct.setCategory_id(product.getCategory_id());
        return entityManager.merge(product);
    }

    @Transactional
    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public long deleteProduct(@PathVariable long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        return product.getId();
    }
}
