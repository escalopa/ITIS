package handlers;

import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;
import java.util.Random;

public class RandomFunctions implements MainHandler {
    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        String username;
        if (request.getSession() != null)
            username = request.getSession().getUsername();
        else
            username = "Unknown User";

        if (request.getMethod().equals("GET"))
            get(request, response, username);
        else if (request.getMethod().equals("POST"))
            post(request, response, username);
    }

    private void get(HttpRequest request, HttpResponse response, String username) throws IOException {
        int random = new Random().nextInt(1000);
        response.setBody("The random generated number for user :" + username + " is  " + random);
        response.send();
    }

    private void post(HttpRequest request, HttpResponse response, String username) throws IOException {
        String sentence = getSentence(request);
        response.setBody("The sentence that was said by:{" + username + "} is  \"" + sentence+"\"");
        response.send();
    }

    private String getSentence(HttpRequest request) {
        if (request.getBody() != null)
            return request.getBody().replaceAll("sentence|[&]|[?]|[=]","");
        else
            return "";
    }
}
