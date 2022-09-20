package handlers;

import utils.Pages;
import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;

public class ErrorHandler implements MainHandler{

    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        response.setBody(Pages.ERROR_PAGE);
        response.send();
    }
}
