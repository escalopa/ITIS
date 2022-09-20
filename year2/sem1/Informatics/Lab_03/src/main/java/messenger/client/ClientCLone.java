package messenger.client;

import lombok.Data;

import java.io.*;
import java.net.Socket;

@Data
public class ClientCLone {

    final static String username = null;
    final static String SERVER_HOST = "127.0.0.1";
    final static int SERVER_PORT = 10000;
    public static Socket clientSocket;
    private static BufferedReader reader;
    public static BufferedReader in;
    public static BufferedWriter out;

    public ClientCLone(BufferedReader reader) {
        this.reader = reader;
    }

    public ClientCLone(){}
    public static void main(String[] args) {
        startChatting();
    }
    public static void startChatting() {
        try {
            try {

                clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
                System.out.println("Connected to server");
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                Thread clientReader = new Thread(){
                    @Override
                    public void run() {
                        while(in != null){
                            try {
                                String input = in.readLine();
                                System.out.println(input);
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                    }
                };
                clientReader.start();
//                ClientReader clientReader = new ClientReader(in);
//                clientReader.start();
//                clientReader.setDaemon(true);

//                ClientReader clientReader = new ClientReader(in);
//                clientReader.start();

                System.out.println("Enter your name:");
                String name = reader.readLine();
                out.write(name + "\n");
                out.flush();
                System.out.println(in.readLine());
                String message = "";
                do {
                    message = reader.readLine();
                    System.out.println("tried to send a msg");
                    if (!message.equals("\\q")) {
                        out.write(message);
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