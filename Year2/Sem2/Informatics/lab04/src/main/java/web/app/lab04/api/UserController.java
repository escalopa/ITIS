package web.app.lab04.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;
import web.app.lab04.dto.UserDto;
import web.app.lab04.models.Role;
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

//    @Autowired
//    private MyEntityManagerFactory myEntityManagerFactory;


    @GetMapping(path = {"/", ""}, produces = "application/json")
    public List<User> getAllUser() {
            return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public User getUser(@PathVariable long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody UserDto userDto) {
        User user = new User();
        String salt = RandomStringUtils.random(10, true, true);

        Role role = entityManager.find(Role.class, userDto.getRole_id());
        user.setRole(role);
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPassword(userDto.getPassword());
        user.setSalt(salt);
        setUserPassword(user, user.getPassword());
        entityManager.persist(user);
        return user;
    }

    @Transactional
    @PutMapping(path = "/{id}/edit", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
        User originalUser = entityManager.find(User.class, id);
        user.setId(originalUser.getId());
        user.setSalt(originalUser.getSalt());
        setUserPassword(user, user.getPassword());
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public long deleteUser(@PathVariable long id) {
        User User = entityManager.find(User.class, id);
        entityManager.remove(User);
        return User.getId();
    }

    private void setUserPassword(User user, String password) {
        String hash = DigestUtils.sha256Hex((user.getSalt() + password + user.getSalt()));
        user.setPassword(hash);
    }
}
