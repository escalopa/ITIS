package handlers;

import utils.Pages;
import webApp.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RootHandler implements MainHandler {
    @Override
    public void process(HttpRequest req, HttpResponse res) throws IOException {
        res.setBody(Pages.WELCOME_PAGE);
        res.send();
    }
}
