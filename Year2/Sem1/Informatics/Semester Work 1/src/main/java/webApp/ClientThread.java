package webApp;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class ClientThread extends Thread {
    private final Socket socket;
    private final Context context;

    public ClientThread(Socket socket, Context context) {
        this.socket = socket;
        this.context = context;
    }

    @Override
    public void run() {

        try {
            HttpRequest req = new HttpRequest(socket.getInputStream());
            HttpResponse res = new HttpResponse(socket.getOutputStream());

            String sessionId = req.getCookies().get("JSESSION");
            if (sessionId != null) {
                req.setSession(context.getSession(sessionId));
            }

            if (req.getPath() == null) {
                throw new IOException();
            }
            context.getContext(req.getPath()).process(req, res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignore) {
            }
            System.out.println("Socket Closed: " + socket);
        }
    }
}
