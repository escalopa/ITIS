import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Methods {


    private static List<User> users = new LinkedList<>();
    private static List<Group> groups = new LinkedList<>();
    private static List<Membership> memberships = new LinkedList<>();
    private static List<Subscription> subscriptions = new LinkedList<>();


    public static void main(String[] args) {

    }
    public static void read(String userPath, String groupPath, String memberShip, String subscriptionsPath) throws IOException {

        BufferedReader br;
        String line;
        String[] data;
        br = new BufferedReader(new FileReader(userPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            data = line.split(",");
            users.add(new User(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3])));
        }
        br = new BufferedReader(new FileReader(groupPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            data = line.split(",");
            groups.add(new Group(Integer.parseInt(data[0]), data[1], getUser(Integer.parseInt(data[2]))));
        }
        br = new BufferedReader(new FileReader(memberShip));
        br.readLine();
        while ((line = br.readLine()) != null) {
            data = line.split(",");
            memberships.add(new Membership(getUser(Integer.parseInt(data[0])), getGroup(Integer.parseInt(data[1]))));
        }
        br = new BufferedReader(new FileReader(subscriptionsPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            data = line.split(",");
            subscriptions.add(new Subscription(getUser(Integer.parseInt(data[0])), getUser(Integer.parseInt(data[1]))));
        }
    }

    private static User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    private static Group getGroup(int id) {
        for (Group group : groups) {
            if (group.getId() == id)
                return group;
        }
        return null;
    }

    public static void task1(String city) {
        HashMap<Group, Integer> map = new HashMap<>();
        for (Membership membership : memberships) {
            if (membership.getUser().getCity().equals(city)) {
                Group tempGroup = membership.getGroup();
                if (map.containsKey(tempGroup)) {
                    map.put(tempGroup, map.get(tempGroup) + 1);
                } else
                    map.put(tempGroup, 1);
            }
        }
        map.keySet().forEach(key -> System.out.println(key.getName() + "=" + map.get(key)));
    }

    public static void task2(String city) {
        int usersFromCity = 0;
        for (User user : users) {
            if (user.getCity().equals(city))
                usersFromCity++;
        }
        HashMap<User, Integer> map = new HashMap<>();
        for (Subscription subscription : subscriptions) {
            if (subscription.getUser1().getCity().equals(city)) {
                User tempUser = subscription.getUser2();
                if (map.containsKey(tempUser))
                    map.put(tempUser, map.get(tempUser) + 1);
                else
                    map.put(tempUser, 1);
            }
        }
        final int max = usersFromCity;
        map.keySet().stream().filter(key -> map.get(key) == max).forEach(key -> System.out.println(key.toString()));
    }
}