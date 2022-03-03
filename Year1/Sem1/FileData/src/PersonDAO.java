
public interface PersonDAO {

    boolean create(Person person);

    Person[] readAll();

    Person read(int id) throws Exception;

    Person[] findBy(String what, String where) throws Exception;

    boolean save();
    boolean saveAs(String filename);

    boolean delete(int id);
}
