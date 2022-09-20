package webApp;

import handlers.*;
import lombok.Data;

import java.util.*;
import java.util.logging.Handler;

@Data
public class Context {

    //Handlers & Session & Cookies
    private Map<String, MainHandler> handlers = new HashMap<>();
    private Map<String, Session> sessionMap = new HashMap<>();

    public void createContext(String path, MainHandler handler) {
        handlers.put(path, handler);
    }

    public void setSession(String key, Session session) {
        sessionMap.entrySet().removeIf((e) -> e.getValue().equals(session));
        this.sessionMap.put(key, session);
    }

    public Session getSession(String key) {
        return sessionMap.get(key);
    }

    public MainHandler getContext(String path) {

        System.out.println("localhost:" + path);

        // filtering path
        if (path.equals("/"))
            path = "";
        else if (path.endsWith("?"))
            path = path.substring(0,path.length()-1);

        // re
        if (path.endsWith(".css") || path.endsWith(".jpg") || path.endsWith(".html")) {
            return new ServerFileHandler();
        }
        if (handlers.containsKey(path)) {
            return handlers.get(path);
        } else if (handlers.containsKey("/404")) {
            return handlers.get("/404");
        } else {
            return handlers.get("/");
        }
    }
}
