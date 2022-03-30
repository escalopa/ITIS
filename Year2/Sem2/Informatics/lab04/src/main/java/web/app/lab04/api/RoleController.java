package web.app.lab04.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.app.lab04.dbService.MyEntityManagerFactory;
import web.app.lab04.models.Role;
import web.app.lab04.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@RestController
@RequestMapping("roles")
public class RoleController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path = {"/", ""}, produces = "application/json")
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    public Role getRole(@PathVariable long name) {
        return entityManager.find(Role.class, name);
    }
}
