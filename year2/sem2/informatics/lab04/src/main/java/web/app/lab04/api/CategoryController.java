package web.app.lab04.api;

import org.springframework.web.bind.annotation.*;
import web.app.lab04.models.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path = {"/", ""}, produces = "application/json")
    public List<Category> getCategories() {
        return entityManager.createQuery("SELECT c FROM category c", Category.class).getResultList();
    }
}
