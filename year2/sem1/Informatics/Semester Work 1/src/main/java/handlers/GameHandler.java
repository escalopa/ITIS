package handlers;

import utils.Pages;
import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;

public class GameHandler implements MainHandler {

    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        String user = getName(request);

        response.setBody(Pages.GAME_PAGE.replace("%user%", user));
        response.send();
    }

    private String getName(HttpRequest request) {
        if (request.getSession() != null)
            return request.getSession().getUsername();
        else
            return "Unknown User";
    }
}
