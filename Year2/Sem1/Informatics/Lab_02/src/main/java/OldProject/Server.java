package OldProject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static final int number = new Random().nextInt(10);

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(100);
                System.out.println("Server Launched !");
                clientSocket = server.accept();
                System.out.println("Client Connected");
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                    out.write("Hello You got connected to the server :D\n");
//                    out.flush();
                    System.out.println("Random number equals: " + number);
                    for (int i = 0; i < 3; i++) {
                        String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                        System.out.println("Client's reply: " + word);
                        // не долго думая отвечает клиенту
                        if (word.equals(String.valueOf(number))) {
                            out.write("Matches\n");
                            out.flush();
                            break;
                        } else
                            out.write("Doesn't Match\n");
                        out.flush();
                    }
                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server shut down successfully!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
