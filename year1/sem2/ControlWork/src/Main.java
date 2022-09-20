import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //Note that the files are empty
        String playersPath = "players.txt";
        String clubsPath = "clubs.txt";
        String clubAffiliationPath = "clubAffiliation.txt";
        Methods.readData(playersPath, clubsPath, clubAffiliationPath);

        //Task 1
        String country = "";
        String clubName = "";
        Methods.task1(country, clubName);

        //Task2
        int specificYear = 0;
        Methods.task2(specificYear);

        //Task3
        String city = "";
        Methods.task3(city);

    }
}
