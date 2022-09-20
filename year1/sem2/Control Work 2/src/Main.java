import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String usersPath= "Users.csv";
        String groupsPath= "Groups.csv";
        String membershipPath="Memberships.csv";
        String subscriptionsPath="Subscriptions.csv";

        Methods.read(usersPath,groupsPath,membershipPath,subscriptionsPath);
        Methods.task1("Moscow");
        Methods.task2("Moscow");
    }
}
