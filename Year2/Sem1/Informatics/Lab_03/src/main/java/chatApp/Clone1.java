package chatApp;

import java.util.Scanner;

public class Clone1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatClient chatClient = new ChatClient(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
        chatClient.execute();
    }
}
