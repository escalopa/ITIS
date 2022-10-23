package messenger.server;

import javax.crypto.spec.PSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Server {

    private static final int PORT = 10000;
    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    public static HashMap<String, List<Message>> clientList = new HashMap<>();
    public static HashMap<String, Writer> outStreamList = new HashMap<>();


    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server Launched !");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread stopper = new Thread(() -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Type \\q to close server\n\r");
                if (scanner.nextLine().equalsIgnoreCase("\\q"))
                    break;
                else
                    System.out.println("Wrong command");
            }
        });

        stopper.start();

        while (stopper.isAlive()) {
            try {
                clientSocket = serverSocket.accept();
                new ConversationHandler(clientSocket, clientList, outStreamList).start();
                //new ConversationHandler(clientSocket, clientList, outStreamList).process();
                System.out.println("Client : "+ clientSocket.toString()+" got connected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
