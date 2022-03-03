import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Methods {

    static List<Actor> actorList = new LinkedList<>();
    static List<Producer> producerList = new LinkedList<>();
    static List<Film> filmList = new LinkedList<>();
    static List<Participant> participantList = new LinkedList<>();

    public static void readData(String actorsPath, String producersPath, String filmsPath, String participantsPath) throws IOException {

        BufferedReader br;
        String line;
        String[] block;

        br = new BufferedReader(new FileReader(actorsPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            block = line.split(",");
            actorList.add(new Actor(block[0], Integer.parseInt(block[1]), Integer.parseInt(block[2])));
        }

        br = new BufferedReader(new FileReader(producersPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            block = line.split(",");
            producerList.add(new Producer(block[0], Integer.parseInt(block[1])));
        }

        br = new BufferedReader(new FileReader(filmsPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            block = line.split(",");
            filmList.add(new Film(block[0], Integer.parseInt(block[1]), getProducer(Integer.parseInt(block[2])), Integer.parseInt(block[3])));
        }

        br = new BufferedReader(new FileReader(participantsPath));
        br.readLine();
        while ((line = br.readLine()) != null) {
            block = line.split(",");
            participantList.add(new Participant(getFilm(Integer.parseInt(block[0])), getActor(Integer.parseInt(block[1])), block[2]));
        }

    }

    private static Actor getActor(int id) {
        for (Actor actor : actorList)
            if (actor.getId() == id)
                return actor;
        return null;
    }

    private static Producer getProducer(int id) {
        for (Producer producer : producerList)
            if (producer.getId() == id)
                return producer;
        return null;
    }

    private static Film getFilm(int id) {
        for (Film film : filmList)
            if (film.getId() == id)
                return film;
        return null;
    }

    public static void task1(String name, int year) {
        filmList.stream().filter(w -> w.getProducer().getName().equals(name) && w.getPublishDate() == year).forEach(System.out::println);
    }

    public static void task2() {

        HashMap<String, Integer> map = new HashMap<>();
        for (Participant participant : participantList) {
            String pair = participant.getFilm().getProducer().getName() + " & " + participant.getActor().getName();
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }
        for (String w : map.keySet()) {
            System.out.println(w + " = " + map.get(w));
        }
    }

    public static void task3(int year) {
        Map<Actor, List<String>> map = new HashMap<>();
        participantList.stream().filter(w -> w.getFilm().getPublishDate() >= year).forEach(e -> {
            if (!map.containsKey(e.getActor())) {
                map.put(e.getActor(), new LinkedList<>());
                map.get(e.getActor()).add(e.getFilm().getProducer().getName());
            }
        });

        for (Actor actor : map.keySet()) {
            if (map.get(actor).size() == 1)
                System.out.println(actor.getName());
        }
    }
}