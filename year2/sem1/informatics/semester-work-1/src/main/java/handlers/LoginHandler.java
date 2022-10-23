package handlers;

import utils.Pages;
import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;

public class LoginHandler implements MainHandler {

    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        response.setBody(Pages.LOGIN_PAGE);
        response.send();
    }
}
