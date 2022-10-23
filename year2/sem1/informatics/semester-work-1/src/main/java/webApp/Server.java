package webApp;

import handlers.*;
import utils.Pages;

import java.io.IOException;
import java.net.*;
import java.util.UUID;

public class Server {

    public static void main(String[] args) {

        Context context = new Context();

        //Prepare all Http handlers
        context.createContext("", new RootHandler());
        context.createContext("/login", new LoginHandler());
        context.createContext("/logout", new LogoutHandler());
        context.createContext("/game", new GameHandler());
        context.createContext("/random", new RandomFunctions());
        context.createContext("/404", new ErrorHandler());
        context.createContext("/profile", new ProfileHandler((session) -> {
            String key = UUID.randomUUID().toString();
            context.setSession(key, session);
            System.out.println("KEY: "+context.getSession(key));
            return key;
        }));

        //Read all html files for later use
        Pages.readPages();

        try {
            final int PORT = 8080;
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Connect to server on PORT : " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Socket Created: " + socket);
                new Thread(new ClientThread(socket, context)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

