import java.util.Comparator;

public class User<T, L, S, K, Q> implements Comparator<User<T, L, S, K, Q>> {

    private final T id;
    private final L name;
    private final S email;
    private final K city;
    private final Q birthYear;
    public int givenLikes;

    public User(T id, L name, S email, K city, Q birthYear) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.birthYear = birthYear;
    }

    public T getId() {
        return id;
    }

    public L getName() {
        return name;
    }

    public S getEmail() {
        return email;
    }

    public K getCity() {
        return city;
    }

    public Q getBirthYear() {
        return birthYear;
    }

    @Override
    public int compare(User<T, L, S, K, Q> o1, User<T, L, S, K, Q> o2) {
        return Integer.compare(o1.givenLikes, o2.givenLikes);
    }
}
