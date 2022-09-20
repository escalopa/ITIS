//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class Methods {
//
//
//    private static List<User> users = new LinkedList<>();
//    private static List<Group> groups = new LinkedList<>();
//    private static List<Membership> memberships = new LinkedList<>();
//    private static List<Subscription> subscriptions = new LinkedList<>();
//
//
//    public static void main(String[] args) {
//
//    }
//    public static void read(String userPath, String groupPath, String memberShip, String subscriptionsPath) throws IOException {
//
//        BufferedReader br;
//        String line;
//        String[] data;
//        br = new BufferedReader(new FileReader(userPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            data = line.split(",");
//            users.add(new User(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3])));
//        }
//        br = new BufferedReader(new FileReader(groupPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            data = line.split(",");
//            groups.add(new Group(Integer.parseInt(data[0]), data[1], getUser(Integer.parseInt(data[2]))));
//        }
//        br = new BufferedReader(new FileReader(memberShip));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            data = line.split(",");
//            memberships.add(new Membership(getUser(Integer.parseInt(data[0])), getGroup(Integer.parseInt(data[1]))));
//        }
//        br = new BufferedReader(new FileReader(subscriptionsPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            data = line.split(",");
//            subscriptions.add(new Subscription(getUser(Integer.parseInt(data[0])), getUser(Integer.parseInt(data[1]))));
//        }
//    }
//
//    private static User getUser(int id) {
//        for (User user : users) {
//            if (user.getId() == id)
//                return user;
//        }
//        return null;
//    }
//
//    private static Group getGroup(int id) {
//        for (Group group : groups) {
//            if (group.getId() == id)
//                return group;
//        }
//        return null;
//    }
//
//    public static void task1(String city) {
//        HashMap<Group, Integer> map = new HashMap<>();
//        for (Membership membership : memberships) {
//            if (membership.getUser().getCity().equals(city)) {
//                Group tempGroup = membership.getGroup();
//                if (map.containsKey(tempGroup)) {
//                    map.put(tempGroup, map.get(tempGroup) + 1);
//                } else
//                    map.put(tempGroup, 1);
//            }
//        }
//        map.keySet().forEach(key -> System.out.println(key.getName() + "=" + map.get(key)));
//    }
//
//    public static void task2(String city) {
//        int usersFromCity = 0;
//        for (User user : users) {
//            if (user.getCity().equals(city))
//                usersFromCity++;
//        }
//        HashMap<User, Integer> map = new HashMap<>();
//        for (Subscription subscription : subscriptions) {
//            if (subscription.getUser1().getCity().equals(city)) {
//                User tempUser = subscription.getUser2();
//                if (map.containsKey(tempUser))
//                    map.put(tempUser, map.get(tempUser) + 1);
//                else
//                    map.put(tempUser, 1);
//            }
//        }
//        final int max = usersFromCity;
//        map.keySet().stream().filter(key -> map.get(key) == max).forEach(key -> System.out.println(key.toString()));
//    }
//
//    static List<Actor> actorList = new LinkedList<>();
//    static List<Producer> producerList = new LinkedList<>();
//    static List<Film> filmList = new LinkedList<>();
//    static List<Participant> participantList = new LinkedList<>();
//
//    public static void readData(String actorsPath, String producersPath, String filmsPath, String participantsPath) throws IOException {
//
//        BufferedReader br;
//        String line;
//        String[] block;
//
//        br = new BufferedReader(new FileReader(actorsPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            block = line.split(",");
//            actorList.add(new Actor(block[0], Integer.parseInt(block[1]), Integer.parseInt(block[2])));
//        }
//
//        br = new BufferedReader(new FileReader(producersPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            block = line.split(",");
//            producerList.add(new Producer(block[0], Integer.parseInt(block[1])));
//        }
//
//        br = new BufferedReader(new FileReader(filmsPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            block = line.split(",");
//            filmList.add(new Film(block[0], Integer.parseInt(block[1]), getProducer(Integer.parseInt(block[2])), Integer.parseInt(block[3])));
//        }
//
//        br = new BufferedReader(new FileReader(participantsPath));
//        br.readLine();
//        while ((line = br.readLine()) != null) {
//            block = line.split(",");
//            participantList.add(new Participant(getFilm(Integer.parseInt(block[0])), getActor(Integer.parseInt(block[1])), block[2]));
//        }
//
//    }
//
//    private static Actor getActor(int id) {
//        for (Actor actor : actorList)
//            if (actor.getId() == id)
//                return actor;
//        return null;
//    }
//
//    private static Producer getProducer(int id) {
//        for (Producer producer : producerList)
//            if (producer.getId() == id)
//                return producer;
//        return null;
//    }
//
//    private static Film getFilm(int id) {
//        for (Film film : filmList)
//            if (film.getId() == id)
//                return film;
//        return null;
//    }
//
//    public static void task1(String name, int year) {
//        filmList.stream().filter(w -> w.getProducer().getName().equals(name) && w.getPublishDate() == year).forEach(System.out::println);
//    }
//
//    public static void task2() {
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for (Participant participant : participantList) {
//            String pair = participant.getFilm().getProducer().getName() + " & " + participant.getActor().getName();
//            map.put(pair, map.getOrDefault(pair, 0) + 1);
//        }
//        for (String w : map.keySet()) {
//            System.out.println(w + " = " + map.get(w));
//        }
//    }
//
//    public static void task3(int year) {
//        Map<Actor, List<String>> map = new HashMap<>();
//        participantList.stream().filter(w -> w.getFilm().getPublishDate() >= year).forEach(e -> {
//            if (!map.containsKey(e.getActor())) {
//                map.put(e.getActor(), new LinkedList<>());
//                map.get(e.getActor()).add(e.getFilm().getProducer().getName());
//            }
//        });
//
//        for (Actor actor : map.keySet()) {
//            if (map.get(actor).size() == 1)
//                System.out.println(actor.getName());
//        }
//    }
//}