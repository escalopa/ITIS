import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String actorPath = "Actors.txt";
        String producerPath = "Producers.txt";
        String filmPath = "Films.txt";
        String participantPath = "Participants.txt";

        String actorName = "";
        int yearTask1 = 0;
        int yearTask3 = 0;

        Methods.readData(actorPath, producerPath, filmPath, participantPath);
        Methods.task1(actorName, yearTask1);
        Methods.task2();
        Methods.task3(yearTask3);
    }
}
