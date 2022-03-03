///*-----------
// - Copyright (c) 2021. This code is licensed under the Binocla (knows as Sergey Shamov aka Tony Stark)
// - and if you delete this text then I will find you by IP :P
// - My credentials: https://vk.com/binocla
// - Or telegram: @binocla
// */
//
//import lombok.SneakyThrows;
//import lombok.extern.java.Log;
//
//import java.lang.reflect.Array;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Log
//public class MainExam {
//    static ArrayList<Sportsman> sportsman;
//    static Array List<Team> team;
//    static ArrayList<Participates> participates;
//    static ArrayList<Match> match;
//    @SneakyThrows
//    public static void main(String[] args) {
//        Path pathToSportsman = Paths.get("/home/binocla/IdeaProjects/examproject/src/main/java/Sportsman.txt");
//        Path pathToParticipants = Paths.get("/home/binocla/IdeaProjects/examproject/src/main/java/Participates.txt");
//        Path pathToTeam = Paths.get("/home/binocla/IdeaProjects/examproject/src/main/java/Team.txt");
//        Path pathToMatch = Paths.get("/home/binocla/IdeaProjects/examproject/src/main/java/Match.txt");
//        /*
//          Reading sportsman from Text File
//         */
//        sportsman = Files.lines(pathToSportsman)
//                .map(x -> {
//                    String[] ar = x.split(",");
//                    return new Sportsman(Integer.parseInt(ar[0]), ar[1], Integer.parseInt(ar[2]), ar[3], ar[4]);
//                }).collect(Collectors.toCollection(ArrayList::new));
//        /*
//          Reading participates from Text File
//         */
//        participates = Files.lines(pathToParticipants)
//                .map(x -> {
//                    String[] ar = x.split(",");
//                    return new Participates(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]), Integer.parseInt(ar[2]), Integer.parseInt(ar[3]));
//                }).collect(Collectors.toCollection(ArrayList::new));
//        /*
//          Reading team from Text File
//         */
//        team = Files.lines(pathToTeam)
//                .map(x -> {
//                    String[] ar = x.split(",");
//                    return new Team(Integer.parseInt(ar[0]), ar[1], ar[2], ar[3], ar[4]);
//                }).collect(Collectors.toCollection(ArrayList::new));
//        /*
//          Reading match from Text File
//         */
//        match = Files.lines(pathToMatch)
//                .map(x -> {
//                    String[] ar = x.split(",");
//                    return new Match(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]), ar[2]);
//                }).collect(Collectors.toCollection(ArrayList::new));
//
//        /*
//          Executing the first task!
//         */
//
//        task1();
//
//        /*
//          Executing the second task!
//         */
//
//        int cnt = task2();
//        log.info("cnt " + cnt + "\n");
//
//        /*
//         Executing the third task!
//         */
//        task3();
//
//
//    }
//
//    /**
//     * By Stream API We traverse the participants, then by sportsman, then by team. All in all it acts like common loop.
//     * We check for several parameters and ensure, that it is correct (point out equalsIgnoreCase method!)
//     * @return could be applied as logging each sportsman (as an expected result)
//     */
//    static void task1() {
//        log.warning("Task 1 executing");
//        IntStream.range(0, participates.size()).filter(x -> participates.get(x).endDate() == -1)
//                .forEach(x -> IntStream.range(0, sportsman.size())
//                        .filter(y -> participates.get(x).idOfSport() == sportsman.get(y).id())
//                        .forEach(l -> IntStream.range(0, team.size())
//                                .filter(f -> participates.get(x).idOfTeam() == team.get(f).id()
//                                && team.get(f).specie().equalsIgnoreCase("football")
//                                && (team.get(f).country().equalsIgnoreCase("russia") || team.get(f).country().equalsIgnoreCase("turkey")))
//                                .forEach(m -> log.info(String.valueOf(sportsman.get(l))))));
//    }
//
//    /**
//     *
//     * @return count of the USA team won matches
//     * we traverse via matches & teams and checking up the result of the game (by picking substring between ':'
//     */
//    static int task2() {
//        log.warning("Task 2 executing");
//        int cntOfUsaWon = 0;
//        for (Match m : match) {
//            for (Team t : team) {
//                if (t.country().equalsIgnoreCase("usa")) {
//                    String firstPart = m.result().substring(0, m.result().indexOf(':'));
//                    String secondPart = m.result().substring(m.result().indexOf(':') + 1);
//                    if (t.id() == m.idFirst() && Integer.parseInt(firstPart) > Integer.parseInt(secondPart)) {
//                        cntOfUsaWon++;
//                    }
//                    if (t.id() == m.idSecond() && Integer.parseInt(firstPart) < Integer.parseInt(secondPart)) {
//                        cntOfUsaWon++;
//                    }
//                }
//            }
//        }
//        return cntOfUsaWon;
//    }
//
//    /**
//     * Task 3 in traversing via teams, participates & sportsmen and counting amount of sportsmen from the USA
//     * @return type could be applied as logging information.
//     * @var countOfUsa is being annulled after each team
//     */
//    static void task3() {
//        log.warning("Task 3 executing");
//        int countOfUsa = 0;
//        for (Team t : team) {
//            for (Participates p : participates) {
//                if (p.endDate() == -1) {
//                    for (Sportsman s : sportsman) {
//                        if (s.fromCountry().equalsIgnoreCase("usa") && s.id() == p.idOfSport() && t.id() == p.idOfTeam()) {
//                            countOfUsa++;
//                            break;
//                        }
//                    }
//                }
//            }
//            log.info(t + ", countOfUsa: " + countOfUsa);
//            countOfUsa = 0;
//        }
//    }
//
//    /**
//     * We traverse by team, participates and sportsman. It is familiar to the previous task, so nothing special!
//     * @return could be applied as logging the expected result
//     */
//    static void task4() {
//        log.warning("Task 3 executing");
//        for (Team t : team) {
//            for (Participates p : participates) {
//                if (p.endDate() == -1) {
//                    for (Sportsman s : sportsman) {
//                        if (s.fromCountry().equalsIgnoreCase(t.country()) && s.id() == p.idOfSport() && t.id() == p.idOfTeam()) {
//                            log.info(s.name() + " " + s.currCountry());
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//record Team(int id, String name, String country, String specie, String captain) {}
//record Sportsman(int id, String name, int date, String fromCountry, String currCountry) {}
//record Participates(int idOfSport, int idOfTeam, int startDate, int endDate) {}
//record Match(int idFirst, int idSecond, String result) {}
