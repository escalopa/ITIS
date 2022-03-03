import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataAnalytics<T, L, S, K, Q> implements Comparator<User<T, L, S, K, Q>> {

    private final List<User<T, L, S, K, Q>> userList;
    private final List<Message<T, L, S, K, Q>> messageList;
    private final List<Like<T, L, S, K, Q>> likesList;
    private final HashMap<User<T, L, S, K, Q>, Integer> hashMap = new HashMap<>();

    public DataAnalytics(String usersPath, String messagesPath, String likesPath) throws IOException {

        String splitter = "\t";
        userList = Files.lines(Path.of(usersPath))
                .map(x -> {
                    String[] ar = x.split(splitter);
                    return new User<T, L, S, K, Q>((T) ar[0], (L) ar[1], (S) ar[2], (K) ar[3], (Q) ar[4]);
                }).collect(Collectors.toCollection(ArrayList::new));
        messageList = Files.lines(Path.of(messagesPath))
                .map(x -> {
                    String[] ar = x.split(splitter);
                    return new Message<T, L, S, K, Q>((T) (ar[0]), (L) ar[1], getUserByID((T) ar[2]));
                }).collect(Collectors.toCollection(ArrayList::new));
        likesList = Files.lines(Path.of(likesPath))
                .map(x -> {
                    String[] ar = x.split(splitter);
                    return new Like<T, L, S, K, Q>(getUserByID((T) ar[0]), getMessageByID((T) ar[1]));
                }).collect(Collectors.toCollection(ArrayList::new));
        howManyLikedMyMessage();
    }

    private User<T, L, S, K, Q> getUserByID(T id) {
        for (User<T, L, S, K, Q> user : userList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    private Message<T, L, S, K, Q> getMessageByID(T id) {
        for (Message<T, L, S, K, Q> message : messageList) {
            if (message.getId() == id)
                return message;
        }
        return null;
    }

    private void howManyLikedMyMessage() {
        for (Like<T, L, S, K, Q> like : likesList) {
            like.getMessage().getAuthor().givenLikes++;
        }
    }

    public void task1() {
        HashMap<User<T, L, S, K, Q>, Integer> map = new HashMap<>();
        likesList.stream()
                .filter(x -> (x.getLiker().getEmail().toString().contains("gmail.com") && x.getMessage().getAuthor() == x.getLiker()))
                .peek(u -> map.put(u.getLiker(), map.getOrDefault(u.getLiker(), 0) + 1))
                .forEach(System.out::println);
    }

    public void task2() {
        HashMap<User<T, L, S, K, Q>, Integer> map = new HashMap<>();
        for (Like<T, L, S, K, Q> like : likesList) {
            if (like.getLiker().getCity().equals(like.getMessage().getAuthor().getCity()))
                if (map.containsKey(like.getLiker()) && map.get(like.getLiker()) == 0)
                    map.put(like.getLiker(), 0);
                else map.put(like.getLiker(), -1);
        }
        for (User<T, L, S, K, Q> user : map.keySet()) {
            if (map.get(user) == 0)
                System.out.println(user);
        }
    }

    public boolean task3() {
        HashMap<User<T, L, S, K, Q>, Integer> map = new HashMap<>();
        for (Like<T, L, S, K, Q> like : likesList) {
            if ((int)like.getLiker().getBirthYear()<(int)like.getMessage().getAuthor().getBirthYear()){
                if (!map.containsKey(like.getLiker()))
                        map.put(like.getLiker(),0);
            }
            else{
                map.put(like.getLiker(),-1);
            }
        }
        for (User<T, L, S, K, Q> user : map.keySet()) {
                if (map.get(user) ==0)
                    return true;
        }
            return false;
    }

    public void task4() {
       Collections.sort(userList<T,L,S,K,Q>);
    }

    @Override
    public int compare(User<T, L, S, K, Q> o1, User<T, L, S, K, Q> o2) {
        return Integer.compare(o1.givenLikes, o2.givenLikes);
    }
}
