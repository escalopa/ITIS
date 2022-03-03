package NewProject;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SubServer extends Thread {
    protected Socket socket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static int uniqueNumber = new Random().nextInt(3);

    public SubServer(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            return;
        }
        String line;
        try {
            while (true) {
                try {
                    line = in.readLine();
                    if ((line == null) || line.equalsIgnoreCase("QUIT")) {

                        return;
                    } else if (line.equals(String.valueOf(uniqueNumber))) {
                        out.write("Matches\n\r");
                        out.flush();
                    } else {
                        out.write("Doesn't Match" + "\n\r");
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
