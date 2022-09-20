public class Group {

    int id;
    String name;
    User creator;

    public Group(int id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getCreator() {
        return creator;
    }
}
