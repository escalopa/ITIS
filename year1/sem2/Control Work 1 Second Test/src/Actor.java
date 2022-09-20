public class Actor {

    String name;
    int id;
    int workingExperience;

    public Actor(String name, int id, int workingExperience) {
        this.name = name;
        this.id = id;
        this.workingExperience = workingExperience;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getWorkingExperience() {
        return workingExperience;
    }
}
