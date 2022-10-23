package handlers;

import utils.Pages;
import utils.SessionSetter;
import webApp.HttpRequest;
import webApp.HttpResponse;
import webApp.Session;

import java.io.IOException;

public class ProfileHandler implements MainHandler {

    SessionSetter sessionSetter;
    public  ProfileHandler(SessionSetter sessionSetter){this.sessionSetter = sessionSetter;}
    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        setCookie(request, response);
        Session userSession = request.getSession();
        String replacement;
        if (userSession == null) {
            replacement = "Unknown User";
        } else {
            replacement = userSession.getUsername();
        }
        response.setBody(Pages.PROFILE_PAGE.replace("%user%", replacement));
        response.send();
    }

    public void setCookie(HttpRequest request, HttpResponse response) {
        if (sessionSetter != null && request.getBody() != null) {
            // parse body to session and
            // add session to header
            Session session = Session.fromString(request.getBody());
            request.setSession(session);
            String sessionKey = sessionSetter.setSession(session);
            response.createCookie("JSESSION", sessionKey, 3600);
        }
    }
}
