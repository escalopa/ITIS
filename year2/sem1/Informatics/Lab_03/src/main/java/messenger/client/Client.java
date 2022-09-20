package messenger.client;

import lombok.Data;

import java.io.*;
import java.net.Socket;

@Data
public class Client {

    final String username = null;
    final String SERVER_HOST = "127.0.0.1";
    final int SERVER_PORT = 10000;
    public Socket clientSocket;
    private BufferedReader reader;
    public BufferedReader in;
    public BufferedWriter out;

    public Client() {
    }

    public void startChatting() {
        try {
            try {

                //Initialize variables
                clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
                System.out.println("Connected to server");
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                //Read the input from the source in an another thread
                Thread clientReader = new Thread(() -> {
                    System.out.println("Listening to the server");
                    while (in != null) {
                        try {
                            String input = in.readLine();
                            System.out.println(input);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientReader.start();

                //Writing msg to the server to process it
                System.out.println("Enter your name:");
                String name = reader.readLine();
                out.write(name + "\n");
                out.flush();

                String message = "";
                do {
                    message = reader.readLine();
                    if (!message.equals("\\q")) {
                        out.write(message + "\n");
                        out.flush();
                    }

                } while (!message.equals("\\q"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.close();
                in.close();
                out.close();
                System.out.println("Connection To the Server is Closed");
                clientSocket.close();
                System.out.println("Client Closed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}