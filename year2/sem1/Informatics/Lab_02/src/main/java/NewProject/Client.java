package NewProject;

import java.io.*;
import java.net.Socket;

public class Client {

    final static String SERVER_HOST = "127.0.0.1";
    final static int SERVER_PORT = 100;
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    private static void writeMessage(String msg) throws IOException {
        out.write(msg + "\n");
        out.flush();
    }

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                while (true) {
                    String word = reader.readLine();
                    //System.out.println("Input was : "+word);
                    if (word.equalsIgnoreCase("QUIT")) {
                        break;
                    }
                    writeMessage(word);
                    String serverWord = in.readLine();
                    System.out.println("Server's reply: " + serverWord);
                    if (serverWord.equals("Matches")) {
                        System.out.println("Correct answer");
                        break;
                    } else
                        System.out.println("Wrong answer");
                }
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
