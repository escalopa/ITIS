package web.app.lab04.dbService;

import web.app.lab04.utils.SQLPrepare;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MyEntityManager implements javax.persistence.EntityManager {

    DB db;

    public MyEntityManager(DB db) {
        this.db = db;
    }

    @Override
    public void persist(Object o) {
        try {
            //Get table name
            String table_name = o.getClass().getAnnotation(Entity.class).name();

            //Get columns and vlaues
            String columns = SQLPrepare.getColumns(o);
            String values = SQLPrepare.getValues(o);

            //Insert into db
            String sql = "INSERT INTO " + table_name + " ( " + columns + " ) "
                    + "VALUES" + " ( " + values + " ) RETURNING id";
            ResultSet resultSet = db.getConnection().createStatement().executeQuery(sql);
            resultSet.next();

            //Set id value to object
            long id = resultSet.getInt("id");
            Field field = o.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(o, id);

        } catch (IllegalAccessException | SQLException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T merge(T t) {
        try {
            Field field = t.getClass().getDeclaredField("id");
            field.setAccessible(true);
            Object id = field.get(t);
            Object object = find(t.getClass(), id);
            if (object == null) return null;

            //Prepare sql query
            String table_name = object.getClass().getAnnotation(Entity.class).name();
            String preparedUpdateQuery = SQLPrepare.prepareUpdateQuery(t);
            String sql = "UPDATE " + table_name + " SET " + preparedUpdateQuery + " WHERE id = " + id;
            return db.getConnection().createStatement().execute(sql) ? (T) object : null;
        } catch (IllegalAccessException | NoSuchFieldException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(Object o) {
        if (o == null) return;
        try {
            //Prepare sql query
            String table_name = o.getClass().getAnnotation(Entity.class).name();
            Field field = o.getClass().getDeclaredField("id");
            field.setAccessible(true);
            Object id = field.get(o);
            String sql = " DELETE FROM " + table_name + " WHERE id = " + id;

            //Delete instance from db
            db.getConnection().createStatement().execute(sql);
        } catch (NoSuchFieldException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T find(Class<T> aClass, Object o) {
        try {
            Object object = ((Class<?>) aClass).getDeclaredConstructor().newInstance();

            //Prepare sql query
            String table_name = aClass.getAnnotation(Entity.class).name();
            String columns = "id," + SQLPrepare.getColumns(object);
            String sql = "SELECT " + columns + " FROM " + table_name + " WHERE id = " + o;

            //Fetch data from db
            ResultSet resultSet = db.getConnection().createStatement().executeQuery(sql);
            if (!resultSet.next()) return null;

            //Inject data in our class
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String dbColumn_name = field.getAnnotation(Column.class).name();
                if (field.getType().equals(String.class))
                    field.set(object, resultSet.getString(dbColumn_name));
                else if (field.getType().equals(Integer.class))
                    field.set(object, resultSet.getInt(dbColumn_name));
                else if (field.getType().equals(Long.class))
                    field.set(object, resultSet.getLong(dbColumn_name));
            }
            return (T) object;
        } catch (SQLException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T getReference(Class<T> aClass, Object o) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public FlushModeType getFlushMode() {
        return null;
    }

    @Override
    public void setFlushMode(FlushModeType flushModeType) {

    }

    @Override
    public void lock(Object o, LockModeType lockModeType) {

    }

    @Override
    public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o) {

    }

    @Override
    public void refresh(Object o, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void detach(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public LockModeType getLockMode(Object o) {
        return null;
    }

    @Override
    public void setProperty(String s, Object o) {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public Query createQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaUpdate criteriaUpdate) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaDelete criteriaDelete) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNamedQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, Class aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, String s1) {
        return null;
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
        return null;
    }

    @Override
    public void joinTransaction() {

    }

    @Override
    public boolean isJoinedToTransaction() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public Object getDelegate() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return null;
    }

    @Override
    public Metamodel getMetamodel() {
        return null;
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return null;
    }

    @Override
    public EntityGraph<?> createEntityGraph(String s) {
        return null;
    }

    @Override
    public EntityGraph<?> getEntityGraph(String s) {
        return null;
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
        return null;
    }

}
