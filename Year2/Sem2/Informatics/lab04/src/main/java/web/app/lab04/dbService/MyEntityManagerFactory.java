package web.app.lab04.dbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyEntityManagerFactory {

    private CharSequence url;

    @Autowired
    private DB db;

    private Map<Long, MyEntityManager> entityManagerMap = new HashMap<>();

    private Map<String, Map<String, Class>> structureDB;

    public MyEntityManagerFactory() {
        entityManagerMap = new HashMap<>();
    }

    public MyEntityManagerFactory(CharSequence url) {
        this.url = url;
    }

    public MyEntityManager getEntityManager() {
        Long id = Thread.currentThread().getId();
        MyEntityManager em = entityManagerMap.get(id);
        if (em == null) {
            em = new MyEntityManager(db);
        }
        return em;
    }

    public void closeEntityManager() {
        Long id = Thread.currentThread().getId();
        entityManagerMap.remove(id);
    }

    public String testDbWork() {
        return this.toString();
    }

    public void destroy() {
        try {
            if (db.getConnection() != null && !db.getConnection().isClosed()) {
                db.getConnection().close();
            }
            System.out.println("DbWork destroed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
