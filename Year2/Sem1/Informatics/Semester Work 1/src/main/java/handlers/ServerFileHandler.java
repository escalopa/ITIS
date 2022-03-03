package handlers;

import utils.Pages;
import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;

public class ServerFileHandler implements MainHandler {
    @Override
    public void process(HttpRequest req, HttpResponse res) throws IOException {
        final String body = Pages.getPage(req.getPath());
        if(body != null) {
            res.setBody(body);
        } else {
            res.setBody(Pages.ERROR_PAGE);
        }
        res.send();
    }
}

