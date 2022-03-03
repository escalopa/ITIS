public class Player {

    String name;
    int id;
    String role;
    String country;
    String bd;

    public int getId() {
        return id;
    }

    public Player(String name, int id, String role, String country, String bd) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.country = country;
        this.bd = bd;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                ", country='" + country + '\'' +
                ", bd=" + bd +
                '}';
    }
}
