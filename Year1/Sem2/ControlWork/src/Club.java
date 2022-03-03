public class Club {

    String name;
    int id;
    int foundationYear;
    String city;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Club(String name, int id, int foundationYear, String city) {
        this.name = name;
        this.id = id;
        this.foundationYear = foundationYear;
        this.city = city;
    }
}
