import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Methods {


    private static List<ClubAffiliation> clubAffiliation = new LinkedList<>();
    private static List<Club> clubs = new LinkedList<>();
    private static List<Player> players = new LinkedList<>();

    public static void readData(String playerFilePath, String clubFilePath, String clubAffiliationFilePath) throws IOException {
        BufferedReader bf;
        String line;

        bf = new BufferedReader(new FileReader(playerFilePath));
        bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] row = line.split(",");
            players.add(new Player(row[0], Integer.parseInt(row[1]), row[2], row[3], row[4]));
        }

        bf = new BufferedReader(new FileReader(clubFilePath));
        bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] row = line.split(",");
            clubs.add(new Club(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]), row[3]));
        }

        bf = new BufferedReader(new FileReader(clubAffiliationFilePath));
        bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] row = line.split(",");
            clubAffiliation.add(new ClubAffiliation(getClub(Integer.parseInt(row[1])), getPlayer(Integer.parseInt(row[0]))
                    , Integer.parseInt(row[2]), Integer.parseInt(row[3])));
        }

        bf.close();
    }

    private static Player getPlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id)
                return player;
        }
        return null;
    }

    private static Club getClub(int id) {
        for (Club club : clubs) {
            if (club.getId() == id)
                return club;
        }
        return null;
    }

    public static void task1(String country, String club) {
        clubAffiliation.stream().filter(cf -> cf.getClub().getName().equals(club) && cf.getPlayer().getCountry().equals(country)).forEach(System.out::println);
    }

    public static void task2(int year) {
        HashMap<String, Integer> clubMoney = new HashMap<>();
        List<ClubAffiliation> clubAffiliations = clubAffiliation.stream().filter(cas -> cas.wasIConnectedInThisYear(year)).collect(Collectors.toList());
        for (ClubAffiliation clubAff : clubAffiliations) {
            String word = clubAff.getClub().getName();
            clubMoney.put(word, (clubMoney.getOrDefault(word, 0)) + 1);
        }
        System.out.println(clubMoney.toString());
    }

    public static void task3(String city) {
        HashMap<String, Integer> player_PlayedGames = new HashMap<>();
        for (ClubAffiliation clubAff : clubAffiliation) {
            if (!clubAff.getClub().getCity().equals(city)) continue;
            String name = clubAff.getPlayer().getName();
            player_PlayedGames.put(name, (player_PlayedGames.getOrDefault(name, 0)) + 1);
        }
        for (String key : player_PlayedGames.keySet()) {
            System.out.println(key + " " + player_PlayedGames.get(key));
        }
    }
}
