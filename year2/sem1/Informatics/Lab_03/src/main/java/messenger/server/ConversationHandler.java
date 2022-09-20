package messenger.server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConversationHandler extends Thread {

    private String username;
    private final Socket clientSocket;
    private HashMap<String, List<Message>> clientMessages;
    private HashMap<String, Writer> outStreamList;

    public ConversationHandler(Socket clientSocket, HashMap<String, List<Message>> clientMessages, HashMap<String, Writer> outStreamList) {
        this.clientSocket = clientSocket;
        this.clientMessages = clientMessages;
        this.outStreamList = outStreamList;
    }

    @Override
    public void run() {
        process();
    }

    public void process() {
        try {

            //Prepare Read & Write
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            username = in.readLine().trim();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            out.write("You signed in successfully as : " + username + "\n");
            out.flush();
            outStreamList.put(username, out);

            //Print All previous msg for this client(username)
            if (clientMessages.containsKey(username)) {
                for (Message message : clientMessages.get(username)) {
                    out.write(message.toString() + "\n");
                }
                out.flush();
            } else {
                clientMessages.put(username, new LinkedList<>());
            }

            // Reading Clients input and processing it
            while (clientSocket.isConnected()) {
                String input = in.readLine();
                if (input != null) {
                    Message msg = new Message().getMSG(input, username);
                    String receiver = msg.getReceiver_username();
                    if (outStreamList.containsKey(receiver))
                        outStreamList.get(receiver).write(msg.toString() + "\n");
                    else if (clientMessages.containsKey(receiver))
                        clientMessages.get(receiver).add(msg);
                    else
                        outStreamList.get(username)
                                .write("\u001B[31m" + "Username that you have been trying to text does not exists "
                                        + "\u001B[0m" + "\n");
                    out.flush();
                }
            }
            outStreamList.remove(username);
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
