package web.app.lab04.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.app.lab04.dbService.MyEntityManagerFactory;
import web.app.lab04.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MyEntityManagerFactory myEntityManagerFactory;


    @GetMapping(path = {"/", ""}, produces = "application/json")
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public User getUser(@PathVariable long id) {
        return myEntityManagerFactory.getEntityManager().find(User.class, id);
    }

    @Transactional
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User user) {
        user.setSalt(RandomStringUtils.random(10, true, true));
        setUserPassword(user, user.getPassword());
        myEntityManagerFactory.getEntityManager().persist(user);
        return user;
    }

    @Transactional
    @PutMapping(path = "/{id}/edit", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
        User originalUser = entityManager.find(User.class, id);
        user.setId(originalUser.getId());
        user.setSalt(originalUser.getSalt());
        setUserPassword(user, user.getPassword());
        myEntityManagerFactory.getEntityManager().merge(user);
        return user;
    }

    @Transactional
    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public long deleteUser(@PathVariable long id) {
        User User = entityManager.find(User.class, id);
        myEntityManagerFactory.getEntityManager().remove(User);
        return User.getId();
    }

    private void setUserPassword(User user, String password) {
        String hash = DigestUtils.sha256Hex((user.getSalt() + password + user.getSalt()));
        user.setPassword(hash);
    }
}
