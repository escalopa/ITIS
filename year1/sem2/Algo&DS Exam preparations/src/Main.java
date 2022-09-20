import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        String usersPath = "";
        String messagesPath = "";
        String likesPath = "";

        DataAnalytics<Integer,String,String,String,Integer> dataAnalytics = new DataAnalytics<>(usersPath,messagesPath,likesPath);

    }

}
