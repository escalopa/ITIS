public class User {

    int id;
    String name;
    String city;
    int  year;

    public User(int id, String name, String city, int year) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", year=" + year +
                '}';
    }
}
